package com.giacom.simple_workflow.domain

data class ProcessDefinition(
    val id: Long = 0,
    val name: String,
    val description: String,
    val tasks: List<TaskDefinition> = mutableListOf()
)
