package com.giacom.simpletask.adapters.input.controller.request

import jakarta.validation.constraints.NotBlank

data class TaskDefinitionStepCreateRequest(
    @NotBlank
    val stepName: String,
    @NotBlank
    val stepDescription: String,
    @NotBlank
    val stepNumber: Int = 1,
    val stepHandler: String? = null,
    val requiredStartAttributes: String? = null,
    val requiredCompleteAttributes: String? = null
)
