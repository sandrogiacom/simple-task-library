package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.DeleteTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.DeleteTaskStepDefinitionOutput

class DeleteTaskStepDefinitionUseCase(
    private val output: DeleteTaskStepDefinitionOutput
) : DeleteTaskStepDefinitionInput {

    override fun deleteById(id: Long) {
        output.deleteById(id)
    }
}
