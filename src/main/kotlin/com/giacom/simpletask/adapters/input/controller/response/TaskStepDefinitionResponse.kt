package com.giacom.simpletask.adapters.input.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskStepDefinitionResponse(
    val id: Long,
    val stepName: String,
    val stepDescription: String,
    val stepHandler: String? = null,
    val taskDefinitionId: Long? = null
)
