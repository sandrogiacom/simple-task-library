package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskInstance(
    val id: Long = 0,
    val taskDefinition: TaskDefinition,
    val attributes: List<TaskAttributeDefinition> = emptyList(),
    val steps: List<TaskStepInstance> = emptyList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
