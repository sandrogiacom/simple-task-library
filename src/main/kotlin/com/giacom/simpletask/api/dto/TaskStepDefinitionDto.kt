package com.giacom.simpletask.api.dto

import com.giacom.simpletask.application.core.domain.TaskDefinition

data class TaskStepDefinitionDto(
    val id: Long = 0,
    val name: String,
    val description: String,
    val taskDefinition: TaskDefinition,
    val handler: String? = null
)
