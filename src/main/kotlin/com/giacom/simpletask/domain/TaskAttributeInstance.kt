package com.giacom.simpletask.domain

data class TaskAttributeInstance(
    val id: Long = 0,
    val attributeName: String,
    val attributeValue: String? = null,
    val taskInstanceId: Long
)
