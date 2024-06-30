package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskStepDefinition

interface CreateTaskStepDefinitionInput {
    fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition
}
