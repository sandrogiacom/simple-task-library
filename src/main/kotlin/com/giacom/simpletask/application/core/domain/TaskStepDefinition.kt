package com.giacom.simpletask.application.core.domain

data class TaskStepDefinition(
    val id: Long = 0,
    val stepName: String,
    val stepDescription: String,
    val taskDefinition: TaskDefinition,
    val handler: String? = null
)
