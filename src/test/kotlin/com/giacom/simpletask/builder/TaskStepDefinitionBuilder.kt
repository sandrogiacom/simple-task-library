package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStepDefinition

data class TaskStepDefinitionBuilder(
    val id: Long = 0,
    val stepName: String = "",
    val stepDescription: String = "",
    val orderNumber: Int = 0,
    val taskDefinition: TaskDefinition,
    val stepHandler: String? = ""
) {
    fun build(): TaskStepDefinition {
        return TaskStepDefinition(
            id = id,
            stepName = stepName,
            stepDescription = stepDescription,
            orderNumber = orderNumber,
            taskDefinition = taskDefinition,
            stepHandler = stepHandler
        )
    }
}

