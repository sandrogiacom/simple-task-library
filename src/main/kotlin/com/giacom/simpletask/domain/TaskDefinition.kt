package com.giacom.simpletask.domain

data class TaskDefinition(
    val id: Long = 0,
    val name: String,
    val description: String,
    val tasks: List<TaskStepDefinition> = mutableListOf()
)
