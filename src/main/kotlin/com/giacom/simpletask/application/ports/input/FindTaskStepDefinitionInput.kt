package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskStepDefinition

interface FindTaskStepDefinitionInput {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition>
    fun findById(id: Long): TaskStepDefinition
}
