package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskStepInstance(
    val id: Long = 0,
    val taskInstance: TaskInstance,
    val taskStepDefinition: TaskStepDefinition,
    val attributes: List<TaskAttributeInstance> = emptyList(),
    val status: TaskStepStatus = TaskStepStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null,
    val next: TaskStepInstance? = null,
    val previous: TaskStepInstance? = null
)
