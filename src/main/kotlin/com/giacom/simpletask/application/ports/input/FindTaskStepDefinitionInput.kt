package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import java.util.Optional

interface FindTaskStepDefinitionInput {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition>
    fun findById(id: Long): TaskStepDefinition
    fun findByStepName(stepName: String): TaskStepDefinition
}
