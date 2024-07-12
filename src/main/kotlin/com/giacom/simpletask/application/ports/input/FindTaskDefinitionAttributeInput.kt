package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute

interface FindTaskDefinitionAttributeInput {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute>
    fun findById(id: Long): TaskDefinitionAttribute
    fun findByAttributeName(attributeName: String): TaskDefinitionAttribute
}
