package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import java.util.*

interface FindTaskStepDefinitionOutput {
    fun findById(id: Long): Optional<TaskStepDefinition>
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition>
}
