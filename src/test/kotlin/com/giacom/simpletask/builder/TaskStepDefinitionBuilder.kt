package com.giacom.simpletask.builder

import com.giacom.simpletask.domain.TaskDefinition
import com.giacom.simpletask.domain.TaskStepDefinition

data class TaskStepDefinitionBuilder(
    val id: Long = 0,
    val stepName: String = "",
    val stepDescription: String = "",
    val stepNumber: Int = 0,
    val taskDefinition: TaskDefinition,
    val stepHandler: String? = ""
) {
    fun build(): TaskStepDefinition {
        return TaskStepDefinition(
            id = id,
            stepName = stepName,
            stepDescription = stepDescription,
            stepNumber = stepNumber,
            taskDefinition = taskDefinition,
            stepHandler = stepHandler
        )
    }
}

