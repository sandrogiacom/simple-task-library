package com.giacom.simpletask.adapters.input.controller.response

data class TaskStepDefinitionResponse(
    val id: Long,
    val stepName: String,
    val stepDescription: String,
    val stepHandler: String? = null,
    val taskDefinitionId: Long
)
