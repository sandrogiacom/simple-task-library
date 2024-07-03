package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput

class SaveTaskDefinitionUseCase(
    private val saveTaskDefinitionOutput: SaveTaskDefinitionOutput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskDefinitionInput {

    override fun create(taskDefinition: TaskDefinition): TaskDefinition {
        return saveTaskDefinitionOutput.save(taskDefinition)
    }

    override fun update(id: Long, taskDefinition: TaskDefinition): TaskDefinition {
        val existTask = findTaskDefinitionInput.findById(id)
        return saveTaskDefinitionOutput.save(
            taskDefinition.copy(id = existTask.id)
        )
    }

}
