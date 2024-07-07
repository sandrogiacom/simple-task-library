package com.giacom.simpletask.adapters.input.controller.request

import jakarta.validation.constraints.NotBlank

data class TaskStepDefinitionCreateRequest(
    @NotBlank
    val stepName: String,
    @NotBlank
    val stepDescription: String,
    @NotBlank
    val orderNumber: Int,
    val stepHandler: String? = null
)
