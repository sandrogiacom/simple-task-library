package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface FindTaskDefinitionInput {
    fun findById(id: Long): TaskDefinition
    fun findAll(): List<TaskDefinition>
    fun findByName(name: String): TaskDefinition
}
