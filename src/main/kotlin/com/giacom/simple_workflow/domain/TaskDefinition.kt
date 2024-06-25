package com.giacom.simple_workflow.domain

data class TaskDefinition(
    val id: Long = 0,
    val name: String,
    val description: String,
    val process: ProcessDefinition,
    val handler: String? = null
)