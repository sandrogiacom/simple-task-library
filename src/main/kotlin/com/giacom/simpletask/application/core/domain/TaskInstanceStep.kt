package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskInstanceStep(
    val id: Long = 0,
    val taskInstanceId: Long,
    val taskDefinitionStepId: Long,
    val status: TaskStatus = TaskStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
) {
    fun start() {
        startedAt.let { LocalDateTime.now() }
        status.let { TaskStatus.RUNNING }
    }
}
