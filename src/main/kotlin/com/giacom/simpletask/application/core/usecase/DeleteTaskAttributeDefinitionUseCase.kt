package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.DeleteTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.output.DeleteTaskAttributeDefinitionOutput

class DeleteTaskAttributeDefinitionUseCase(
    private val output: DeleteTaskAttributeDefinitionOutput
) : DeleteTaskAttributeDefinitionInput {

    override fun deleteById(id: Long) {
        output.deleteById(id)
    }
}
