package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.*
import java.time.LocalDateTime

data class TaskInstanceBuilder(
    val id: Long = 1L,
    val taskDefinition: TaskDefinition = TaskDefinitionBuilder().build(),
    val attributes: List<TaskInstanceAttribute>? = mutableListOf(),
    val steps: List<TaskInstanceStep>? = mutableListOf(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: TaskStatus = TaskStatus.CREATED,
    val startedAt: LocalDateTime? = LocalDateTime.now(),
    val completedAt: LocalDateTime? = LocalDateTime.now()
) {
    fun build(): TaskInstance {
        return TaskInstance(
            id = id,
            taskDefinition = taskDefinition,
            attributes = attributes,
            steps = steps,
            createdAt = createdAt,
            status = status,
            startedAt = startedAt,
            completedAt = completedAt
        )
    }
}
