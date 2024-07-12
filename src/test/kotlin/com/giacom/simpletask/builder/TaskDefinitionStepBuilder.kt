package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

data class TaskDefinitionStepBuilder(
    val id: Long = 0,
    val stepName: String = "",
    val stepDescription: String = "",
    val stepNumber: Int = 0,
    val taskDefinition: TaskDefinition,
    val stepHandler: String? = ""
) {
    fun build(): TaskDefinitionStep {
        return TaskDefinitionStep(
            id = id,
            stepName = stepName,
            stepDescription = stepDescription,
            stepNumber = stepNumber,
            taskDefinition = taskDefinition,
            stepHandler = stepHandler
        )
    }
}

