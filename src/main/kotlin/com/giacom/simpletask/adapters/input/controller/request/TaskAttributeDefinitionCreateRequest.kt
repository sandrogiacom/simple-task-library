package com.giacom.simpletask.adapters.input.controller.request

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.validation.constraints.NotBlank

data class TaskAttributeDefinitionCreateRequest(
    @NotBlank
    val attributeName: String,
    // bug do spring? erro de parser de json quando data class com apenas um atributo
    @JsonIgnore
    val taskDefinitionId: Long? = null
)
