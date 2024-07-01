package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput

class SaveTaskDefinitionUseCase(
    private val saveTaskDefinitionOutput: SaveTaskDefinitionOutput
) : SaveTaskDefinitionInput {

    override fun save(taskDefinition: TaskDefinition): TaskDefinition {
        return saveTaskDefinitionOutput.save(taskDefinition)
    }

}
