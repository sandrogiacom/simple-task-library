package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.input.CreateTaskInstanceInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskStepInstanceOutput

class CreateTaskInstanceUseCase(
    private val findTaskDefinitionInput: FindTaskDefinitionInput,
    private val createTaskInstanceOutput: SaveTaskInstanceOutput,
    private val createTaskStepInstanceOutput: SaveTaskStepInstanceOutput,
    private val createTaskAttributeInstanceOutput: SaveTaskAttributeInstanceOutput
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

        taskDefinition.taskSteps?.forEach { taskStepDefinition ->
            createTaskStepInstanceOutput.save(
                TaskStepInstance(
                    taskInstanceId = instance.id,
                    taskStepDefinitionId = taskStepDefinition.id!!
                )
            )
        }
        taskDefinition.attributes?.forEach { taskAttributeDefinition ->
            createTaskAttributeInstanceOutput.save(
                TaskAttributeInstance(
                    taskInstanceId = instance.id,
                    attributeName = taskAttributeDefinition.attributeName
                )
            )
        }

        return instance
    }

}
