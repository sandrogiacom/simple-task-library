package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.DeleteTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionOutput

class DeleteTaskDefinitionUseCase(
    private val output: DeleteTaskDefinitionOutput
) : DeleteTaskDefinitionInput {

    override fun deleteById(id: Long) {
        output.deleteById(id)
    }
}
