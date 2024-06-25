package com.giacom.simple_workflow.api.dto

import com.giacom.simple_workflow.domain.ProcessDefinition

data class TaskDefinitionDto(
    val id: Long = 0,
    val name: String,
    val description: String,
    val process: ProcessDefinition,
    val handler: String? = null
)
