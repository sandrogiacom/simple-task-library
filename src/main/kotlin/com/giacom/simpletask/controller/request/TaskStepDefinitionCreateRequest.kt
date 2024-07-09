package com.giacom.simpletask.controller.request

import jakarta.validation.constraints.NotBlank

data class TaskStepDefinitionCreateRequest(
    @NotBlank
    val stepName: String,
    @NotBlank
    val stepDescription: String,
    @NotBlank
    val stepNumber: Int,
    val stepHandler: String? = null
)
