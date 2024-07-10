package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.input.CreateTaskInstanceInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.CreateTaskAttributeInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskStepInstanceOutput

class CreateTaskInstanceUseCase(
    private val findTaskDefinitionInput: FindTaskDefinitionInput,
    private val createTaskInstanceOutput: SaveTaskInstanceOutput,
    private val createTaskStepInstanceOutput: CreateTaskStepInstanceOutput,
    private val createTaskAttributeInstanceOutput: CreateTaskAttributeInstanceOutput
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
            createTaskStepInstanceOutput.create(
                TaskStepInstance(
                    taskInstanceId = instance.id,
                    taskStepDefinitionId = taskStepDefinition.id!!
                )
            )
        }
        taskDefinition.attributes?.forEach { taskAttributeDefinition ->
            createTaskAttributeInstanceOutput.create(
                TaskAttributeInstance(
                    taskInstanceId = instance.id,
                    attributeName = taskAttributeDefinition.attributeName
                )
            )
        }

        return instance
    }

}
