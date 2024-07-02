package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition

interface FindTaskAttributeDefinitionInput {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition>
    fun findById(id: Long): TaskAttributeDefinition
}
