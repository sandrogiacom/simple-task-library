package com.giacom.simple_workflow.api.dto

data class ProcessDefinitionDto(
    val id: Long = 0,
    val name: String,
    val description: String
)
