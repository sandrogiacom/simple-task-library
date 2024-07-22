package com.giacom.simpletask.application.core.domain

data class TaskDefinition(
    val id: Long? = 0,
    val taskName: String,
    val taskDescription: String,
    var taskSteps: List<TaskDefinitionStep>? = mutableListOf(),
    var attributes: List<TaskDefinitionAttribute>? = mutableListOf()
){
    fun addTaskStep(taskStep: TaskDefinitionStep) {
        (taskSteps as MutableList).add(taskStep)
    }

    fun addTaskAttribute(attribute: TaskDefinitionAttribute) {
        (attributes as MutableList).add(attribute)
    }

}
