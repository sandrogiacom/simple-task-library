package com.giacom.simpletask.domain

data class TaskStepDefinition(
    val id: Long = 0,
    val name: String,
    val description: String,
    val taskDefinition: TaskDefinition,
    val handler: String? = null
)
