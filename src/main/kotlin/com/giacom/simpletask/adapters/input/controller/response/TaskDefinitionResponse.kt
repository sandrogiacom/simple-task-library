package com.giacom.simpletask.adapters.input.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskDefinitionResponse(
    val id: Long,
    val taskName: String,
    val taskDescription: String,
    val taskSteps: List<TaskStepDefinitionResponse>?,
    val attributes: List<TaskAttributeDefinitionResponse>?
)
