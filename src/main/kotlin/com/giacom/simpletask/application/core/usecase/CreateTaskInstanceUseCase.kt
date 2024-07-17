package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.ports.input.CreateTaskInstanceInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceStepOutput

class CreateTaskInstanceUseCase(
    private val findTaskDefinitionInput: FindTaskDefinitionInput,
    private val createTaskInstanceOutput: SaveTaskInstanceOutput,
    private val saveTaskInstanceStepOutput: SaveTaskInstanceStepOutput,
    private val saveTaskInstanceAttributeOutput: SaveTaskInstanceAttributeOutput
) : CreateTaskInstanceInput {

    override fun create(taskName: String): TaskInstance {
        val taskDefinition = findTaskDefinitionInput.findByName(taskName)
        val taskInstance = TaskInstance(
            taskDefinition = taskDefinition
        )

        if (taskDefinition.taskSteps?.isEmpty() == true) {
            throw IllegalArgumentException("Task definition steps does not exist")
        }

        val instance = createTaskInstanceOutput.save(taskInstance)

        taskDefinition.taskSteps?.forEach { taskDefinitionStep ->
            saveTaskInstanceStepOutput.save(
                TaskInstanceStep(
                    taskInstanceId = instance.id,
                    taskDefinitionStep = taskDefinitionStep
                )
            )
        }
        taskDefinition.attributes?.forEach { taskDefinitionAttribute ->
            saveTaskInstanceAttributeOutput.save(
                TaskInstanceAttribute(
                    taskInstanceId = instance.id,
                    attributeName = taskDefinitionAttribute.attributeName
                )
            )
        }

        return instance
    }

}
