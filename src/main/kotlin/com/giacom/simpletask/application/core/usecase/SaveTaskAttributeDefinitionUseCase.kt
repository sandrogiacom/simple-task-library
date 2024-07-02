package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.input.SaveTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput

class SaveTaskAttributeDefinitionUseCase(
    private val saveTaskAttributeDefinitionOutput: SaveTaskAttributeDefinitionOutput,
    private val findTaskAttributeDefinitionOutput: FindTaskAttributeDefinitionOutput,
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput
) : SaveTaskAttributeDefinitionInput {

    override fun create(taskDefinitionId: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val taskDefinition = findTaskDefinitionOutput.findById(taskDefinitionId)
            .orElseThrow { RuntimeException("Task definition not found") }
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(taskDefinition = taskDefinition)
        )

    }

    override fun update(id: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val existTaskAttribute = findTaskAttributeDefinitionOutput.findById(id)
            .orElseThrow { RuntimeException("Task Attribute definition not found") }
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(
                id = existTaskAttribute.id,
                taskDefinition = existTaskAttribute.taskDefinition
            )
        )
    }

}
