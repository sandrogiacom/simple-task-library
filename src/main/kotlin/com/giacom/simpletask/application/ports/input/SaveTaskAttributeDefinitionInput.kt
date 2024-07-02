package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition

interface SaveTaskAttributeDefinitionInput {
    fun create(taskDefinitionId: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition
    fun update(id: Long, toDomain: TaskAttributeDefinition): TaskAttributeDefinition
}
