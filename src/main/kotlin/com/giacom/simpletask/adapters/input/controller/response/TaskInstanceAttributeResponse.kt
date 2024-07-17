package com.giacom.simpletask.adapters.input.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskInstanceAttributeResponse(
    val id: Long = 0,
    val attributeName: String,
    val attributeValue: String? = null,
    val taskInstanceId: Long
)
