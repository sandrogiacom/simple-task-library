package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.input.StartTaskInstanceInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput

class StartTaskInstanceUseCase(
    private val findTaskInstanceInput: FindTaskInstanceInput,
    private val taskInstanceOutput: SaveTaskInstanceOutput,
    private val taskInstanceAttributeOutput: SaveTaskInstanceAttributeOutput
) : StartTaskInstanceInput {

    override fun startTask(taskInstanceId: Long, attributes: Map<String, String>?): TaskInstance {
        val taskInstance = findTaskInstanceInput.findById(taskInstanceId)
        val started = taskInstance.startTask()
        started.attributes
        taskInstanceOutput.save(started)
        taskInstanceAttributes(taskInstance, attributes)
        return started
    }

    private fun taskInstanceAttributes(taskInstance: TaskInstance, attributes: Map<String, String>?) {
        attributes?.forEach { (key, value) ->
            run {
                val attribute = TaskInstanceAttribute(
                    attributeName = key,
                    attributeValue = value,
                    taskInstanceId = taskInstance.id
                )
                taskInstance.addAttribute(
                    attribute
                )
                taskInstanceAttributeOutput.save(attribute)
            }
        }

    }

}
