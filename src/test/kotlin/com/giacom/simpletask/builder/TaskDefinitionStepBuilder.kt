package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

data class TaskDefinitionStepBuilder(
    val id: Long = 0,
    val stepName: String = "Task Step ",
    val stepDescription: String = "Task Step description ",
    val stepNumber: Int = 0,
    val taskDefinition: TaskDefinition,
    val stepHandler: String? = "handler"
) {
    fun build(): TaskDefinitionStep {
        return TaskDefinitionStep(
            id = id,
            stepName = stepName + id,
            stepDescription = stepDescription + id,
            stepNumber = id.toInt(),
            taskDefinition = taskDefinition,
            stepHandler = stepHandler
        )
    }

    fun withId(id: Long): TaskDefinitionStepBuilder {
        return this.copy(id = id)
    }
}

