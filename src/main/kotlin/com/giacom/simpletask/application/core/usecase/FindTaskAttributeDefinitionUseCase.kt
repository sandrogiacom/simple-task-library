package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput

class FindTaskAttributeDefinitionUseCase(
    private val findTaskAttributeDefinitionOutput: FindTaskAttributeDefinitionOutput
) : FindTaskAttributeDefinitionInput {

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition> {
        return findTaskAttributeDefinitionOutput.findAllByTaskDefinitionId(taskDefinitionId)
    }

    override fun findById(id: Long): TaskAttributeDefinition {
        return findTaskAttributeDefinitionOutput.findById(id).orElseThrow { RuntimeException("Task definition Attribute not found") }
    }

    override fun findByAttributeName(attributeName: String): TaskAttributeDefinition {
        return findTaskAttributeDefinitionOutput.findByAttributeName(attributeName)
    }


}
