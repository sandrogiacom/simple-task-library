package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.input.CreateTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.CreateTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput

class CreateTaskStepDefinitionUseCase(
    private val createTaskStepDefinitionOutput: CreateTaskStepDefinitionOutput,
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput
) : CreateTaskStepDefinitionInput {

    override fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskDefinition = findTaskDefinitionOutput.findById(taskDefinitionId)
            .orElseThrow { RuntimeException("Task definition not found") }
        return createTaskStepDefinitionOutput.create(
            taskStepDefinition.copy(taskDefinition = taskDefinition)
        )

    }

}
