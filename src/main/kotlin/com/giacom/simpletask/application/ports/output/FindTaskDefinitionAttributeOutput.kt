package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import java.util.*

interface FindTaskDefinitionAttributeOutput {
    fun findById(id: Long): Optional<TaskDefinitionAttribute>
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute>
    fun findByAttributeName(attributeName: String): TaskDefinitionAttribute
}
