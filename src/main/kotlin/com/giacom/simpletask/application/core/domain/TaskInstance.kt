package com.giacom.simpletask.application.core.domain

import java.time.LocalDateTime

data class TaskInstance(
    val id: Long = 0,
    val taskDefinition: TaskDefinition,
    var attributes: List<TaskInstanceAttribute>? = mutableListOf(),
    var steps: List<TaskInstanceStep>? = mutableListOf(),
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

    fun startStep(step: TaskInstanceStep) {
        steps?.find { it.id == step.id }?.start()
    }

    fun completeStep(step: TaskInstanceStep) {

    }

    fun addAttribute(attribute: TaskInstanceAttribute) {
        if (attributes == null) {
            attributes = mutableListOf()
        }
        (attributes as MutableList).add(attribute)
    }

    fun addStep(step: TaskInstanceStep) {
        if (steps == null) {
            steps = mutableListOf()
        }
        (steps as MutableList).add(step)
    }
}
