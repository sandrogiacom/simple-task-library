package com.giacom.simpletask.application.core.domain

data class TaskAttributeInstance(
    val id: Long = 0,
    val attributeName: String,
    val attributeValue: String? = null,
    val taskInstance: TaskInstance
)
