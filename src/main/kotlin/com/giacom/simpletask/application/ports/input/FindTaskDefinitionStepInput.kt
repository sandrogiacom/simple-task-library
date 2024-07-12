package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

interface FindTaskDefinitionStepInput {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStep>
    fun findById(id: Long): TaskDefinitionStep
    fun findByStepName(stepName: String): TaskDefinitionStep
}
