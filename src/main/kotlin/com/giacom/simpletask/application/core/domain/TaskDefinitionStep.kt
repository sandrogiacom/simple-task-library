package com.giacom.simpletask.application.core.domain

data class TaskDefinitionStep(
    val id: Long? = 0,
    val stepName: String,
    val stepDescription: String,
    val stepNumber: Int,
    val taskDefinition: TaskDefinition? = null,
    val requiredStartAttributes: String? = null,
    val requiredCompleteAttributes: String? = null,
    val stepHandler: String? = null
)
