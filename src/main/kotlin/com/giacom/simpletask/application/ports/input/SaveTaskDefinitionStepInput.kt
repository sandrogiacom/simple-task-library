package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

interface SaveTaskDefinitionStepInput {
    fun create(taskDefinitionId: Long, taskDefinitionStep: TaskDefinitionStep): TaskDefinitionStep
    fun update(id: Long, toDomain: TaskDefinitionStep): TaskDefinitionStep
}
