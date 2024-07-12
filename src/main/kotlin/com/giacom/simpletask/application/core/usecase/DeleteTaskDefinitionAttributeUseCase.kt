package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.DeleteTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionAttributeOutput

class DeleteTaskDefinitionAttributeUseCase(
    private val output: DeleteTaskDefinitionAttributeOutput
) : DeleteTaskDefinitionAttributeInput {

    override fun deleteById(id: Long) {
        output.deleteById(id)
    }
}
