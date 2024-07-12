package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionAttributeOutput

class FindTaskDefinitionAttributeUseCase(
    private val findTaskAttributeDefinitionOutput: FindTaskDefinitionAttributeOutput
) : FindTaskDefinitionAttributeInput {

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute> {
        return findTaskAttributeDefinitionOutput.findAllByTaskDefinitionId(taskDefinitionId)
    }

    override fun findById(id: Long): TaskDefinitionAttribute {
        return findTaskAttributeDefinitionOutput.findById(id).orElseThrow { RuntimeException("Task definition Attribute not found") }
    }

    override fun findByAttributeName(attributeName: String): TaskDefinitionAttribute {
        return findTaskAttributeDefinitionOutput.findByAttributeName(attributeName)
    }


}
