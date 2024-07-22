package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.core.domain.TaskStatus
import java.time.LocalDateTime

data class TaskInstanceStepBuilder(
    val id: Long = 0,
    val taskInstanceId: Long = 0,
    val taskDefinitionStep: TaskDefinitionStep,
    val status: TaskStatus = TaskStatus.COMPLETED,
    val startedAt: LocalDateTime? = LocalDateTime.now(),
    val endedAt: LocalDateTime? = LocalDateTime.now()
) {
    fun build(): TaskInstanceStep {
        return TaskInstanceStep(
            id = id,
            taskInstanceId = taskInstanceId,
            taskDefinitionStep = taskDefinitionStep,
            status = status,
            startedAt = startedAt,
            endedAt = endedAt
        )
    }
}
