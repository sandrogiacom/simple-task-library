package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskStepInstance(
    val id: Long = 0,
    val taskInstanceId: Long,
    val taskStepDefinitionId: Long,
    val status: TaskStepStatus = TaskStepStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
)
