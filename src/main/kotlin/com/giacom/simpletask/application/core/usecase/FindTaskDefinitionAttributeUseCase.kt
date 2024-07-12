package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionAttributeOutput

class FindTaskDefinitionAttributeUseCase(
    private val findTaskDefinitionAttributeOutput: FindTaskDefinitionAttributeOutput
) : FindTaskDefinitionAttributeInput {

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute> {
        return findTaskDefinitionAttributeOutput.findAllByTaskDefinitionId(taskDefinitionId)
    }

    override fun findById(id: Long): TaskDefinitionAttribute {
        return findTaskDefinitionAttributeOutput.findById(id).orElseThrow { RuntimeException("Task definition Attribute not found") }
    }

    override fun findByAttributeName(attributeName: String): TaskDefinitionAttribute {
        return findTaskDefinitionAttributeOutput.findByAttributeName(attributeName)
    }


}
