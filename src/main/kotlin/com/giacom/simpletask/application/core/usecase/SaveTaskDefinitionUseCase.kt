package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput

class SaveTaskDefinitionUseCase(
    private val saveTaskDefinitionOutput: SaveTaskDefinitionOutput,
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput
) : SaveTaskDefinitionInput {

    override fun create(taskDefinition: TaskDefinition): TaskDefinition {
        return saveTaskDefinitionOutput.save(taskDefinition)
    }

    override fun update(id: Long, taskDefinition: TaskDefinition): TaskDefinition {
        val existTask = findTaskDefinitionOutput.findById(id)
            .orElseThrow { RuntimeException("Task definition not found") }

        return saveTaskDefinitionOutput.save(
            taskDefinition.copy(id = existTask.id)
        )
    }

}
