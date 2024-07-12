package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import java.util.*

interface FindTaskDefinitionStepOutput {
    fun findById(id: Long): Optional<TaskDefinitionStep>
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStep>
    fun findByStepName(stepName: String): TaskDefinitionStep
}
