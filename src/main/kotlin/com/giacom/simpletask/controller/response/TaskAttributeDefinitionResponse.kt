package com.giacom.simpletask.controller.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskAttributeDefinitionResponse(
    val id: Long,
    val attributeName: String,
    val taskDefinitionId: Long? = null
)
