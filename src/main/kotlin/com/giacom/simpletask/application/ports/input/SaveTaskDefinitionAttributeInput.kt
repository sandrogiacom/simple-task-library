package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute

interface SaveTaskDefinitionAttributeInput {
    fun create(taskDefinitionId: Long, taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttribute
    fun update(id: Long, toDomain: TaskDefinitionAttribute): TaskDefinitionAttribute
}
