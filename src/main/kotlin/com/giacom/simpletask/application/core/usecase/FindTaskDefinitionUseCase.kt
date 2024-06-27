package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.out.FindTaskDefinitionOutput

class FindTaskDefinitionUseCase(
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput
) : FindTaskDefinitionInput {

    override fun findById(id: Long): TaskDefinition {
        return findTaskDefinitionOutput.findById(id).orElseThrow { RuntimeException("Task definition not found") }
    }

}
