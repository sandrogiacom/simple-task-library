package com.giacom.simpletask.adapters.input.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.giacom.simpletask.application.core.domain.TaskStatus
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskInstanceStepResponse(
    val id: Long = 0,
    val taskInstanceId: Long,
    val stepName: String,
    val stepDescription: String,
    val stepNumber: Int,
    val status: TaskStatus = TaskStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
)
