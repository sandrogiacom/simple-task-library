package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskInstance(
    val id: Long = 0,
    val taskDefinition: TaskDefinition,
    val attributes: List<TaskAttributeInstance>? = emptyList(),
    val steps: List<TaskStepInstance>? = emptyList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: TaskStatus = TaskStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val completedAt: LocalDateTime? = null
) {
    fun startTask(): TaskInstance {
        return this.copy(
            status = TaskStatus.RUNNING,
            startedAt = LocalDateTime.now()
        )
    }

    fun startStep(step: TaskStepInstance) {
        steps?.find { it.id == step.id }?.start()
    }

    fun completeStep(step: TaskStepInstance) {

    }

    fun addAttribute(attribute: TaskAttributeInstance) {
        (attributes as MutableList).add(attribute)
    }

    fun addStep(step: TaskStepInstance) {
        (steps as MutableList).add(step)
    }
}
