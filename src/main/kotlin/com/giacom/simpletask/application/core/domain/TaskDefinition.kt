package com.giacom.simpletask.application.core.domain

data class TaskDefinition(
    val id: Long? = 0,
    val taskName: String,
    val taskDescription: String,
    var taskSteps: List<TaskStepDefinition>? = mutableListOf(),
    var attributes: List<TaskAttributeDefinition>? = mutableListOf()
){
    fun addTaskStep(taskStep: TaskStepDefinition) {
        (taskSteps as MutableList).add(taskStep)
    }

    fun addAttribute(attribute: TaskAttributeDefinition) {
        (attributes as MutableList).add(attribute)
    }

}
