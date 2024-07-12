package com.giacom.simpletask.application.core.domain

data class TaskDefinitionAttribute(
    val id: Long? = 0,
    val attributeName: String,
    val taskDefinition: TaskDefinition? = null
)
