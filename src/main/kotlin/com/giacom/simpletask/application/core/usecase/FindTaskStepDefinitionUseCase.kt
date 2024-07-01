package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput

class FindTaskStepDefinitionUseCase(
    private val findTaskStepDefinitionOutput: FindTaskStepDefinitionOutput
) : FindTaskStepDefinitionInput {

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition> {
        return findTaskStepDefinitionOutput.findAllByTaskDefinitionId(taskDefinitionId)
    }

    override fun findById(id: Long): TaskStepDefinition {
        return findTaskStepDefinitionOutput.findById(id).orElseThrow { RuntimeException("Task definition step not found") }
    }


}
