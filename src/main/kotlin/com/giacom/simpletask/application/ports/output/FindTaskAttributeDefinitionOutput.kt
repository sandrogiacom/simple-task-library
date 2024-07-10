package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import java.util.*

interface FindTaskAttributeDefinitionOutput {
    fun findById(id: Long): Optional<TaskAttributeDefinition>
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition>
    fun findByAttributeName(attributeName: String): TaskAttributeDefinition
}
