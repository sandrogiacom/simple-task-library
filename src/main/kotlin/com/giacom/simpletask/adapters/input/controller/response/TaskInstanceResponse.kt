package com.giacom.simpletask.adapters.input.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStatus
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskInstanceResponse(
    val id: Long = 0,
    val taskDefinitionId: Long,
    val taskDefinitionName: String,
    val taskDefinitionDescription: String,
    var attributes: List<TaskInstanceAttributeResponse>? = emptyList(),
    var steps: List<TaskInstanceStepResponse>? = emptyList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: TaskStatus = TaskStatus.CREATED,
    val startedAt: LocalDateTime? = null,
    val completedAt: LocalDateTime? = null
)
