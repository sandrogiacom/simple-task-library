package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput

class SaveTaskAttributeDefinitionUseCase(
    private val saveTaskAttributeDefinitionOutput: SaveTaskAttributeDefinitionOutput,
    private val findTaskAttributeDefinitionInput: FindTaskAttributeDefinitionInput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskAttributeDefinitionInput {

    override fun create(taskDefinitionId: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val taskDefinition = findTaskDefinitionInput.findById(taskDefinitionId)
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(taskDefinition = taskDefinition)
        )

    }

    override fun update(id: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val existTaskAttribute = findTaskAttributeDefinitionInput.findById(id)
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(
                id = existTaskAttribute.id,
                taskDefinition = existTaskAttribute.taskDefinition
            )
        )
    }

}
