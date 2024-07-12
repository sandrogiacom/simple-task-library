package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.DeleteTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionStepOutput

class DeleteTaskDefinitionStepUseCase(
    private val output: DeleteTaskDefinitionStepOutput
) : DeleteTaskDefinitionStepInput {

    override fun deleteById(id: Long) {
        output.deleteById(id)
    }
}
