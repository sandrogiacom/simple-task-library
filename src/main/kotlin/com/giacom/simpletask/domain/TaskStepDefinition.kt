package com.giacom.simpletask.domain

data class TaskStepDefinition(
    val id: Long? = 0,
    val stepName: String,
    val stepDescription: String,
    val stepNumber: Int,
    val taskDefinition: TaskDefinition? = null,
    val stepHandler: String? = null
)
