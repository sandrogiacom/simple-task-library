package com.giacom.simpletask.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class TaskDefinitionCreateRequest(
    @NotBlank
    val name: String,
    @NotBlank
    val description: String
)
