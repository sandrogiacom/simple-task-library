package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.CreateTaskAttributeInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskStepInstanceOutput

class CreateTaskInstanceUseCase(
    private val findTaskDefinitionInput: FindTaskDefinitionInput,
    private val createTaskInstanceOutput: CreateTaskInstanceOutput,
    private val createTaskStepInstanceOutput: CreateTaskStepInstanceOutput,
    private val createTaskAttributeInstanceOutput: CreateTaskAttributeInstanceOutput
) {

    fun create(taskName: String) {
        val taskDefinition = findTaskDefinitionInput.findByName(taskName)
        val taskInstance = TaskInstance(
            taskDefinition = taskDefinition
        )
        taskDefinition.taskSteps?.forEach { taskStepDefinition ->
            taskInstance.addStep(
                TaskStepInstance(
                    taskInstance = taskInstance,
                    taskStepDefinition = taskStepDefinition
                )
            )
        }
        taskDefinition.attributes?.forEach { taskAttributeDefinition ->
            taskInstance.addAttribute(
                TaskAttributeInstance(
                    taskInstance = taskInstance,
                    attributeName = taskAttributeDefinition.attributeName
                )
            )
        }

        createTaskInstanceOutput.create(taskInstance)
        taskInstance.steps?.forEach { step ->
            createTaskStepInstanceOutput.create(step)
        }
        taskInstance.attributes?.forEach { attribute ->
            createTaskAttributeInstanceOutput.create(attribute)
        }
    }

}
