package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskStepDefinition

interface SaveTaskStepDefinitionInput {
    fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition
    fun update(id: Long, toDomain: TaskStepDefinition): TaskStepDefinition
}
