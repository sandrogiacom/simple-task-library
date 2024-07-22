package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

data class TaskDefinitionBuilder(
    val id: Long = 1,
    val taskName: String = "Task 1",
    val taskDescription: String = "Task 1 description",
    var taskSteps: List<TaskDefinitionStep>? = mutableListOf(),
    var attributes: List<TaskDefinitionAttribute>? = mutableListOf()
) {
    fun build(): TaskDefinition {
        return TaskDefinition(
            id = id,
            taskName = taskName,
            taskDescription = taskDescription
        )
    }

    fun withTaskName(taskName: String): TaskDefinitionBuilder {
        return this.copy(taskName = taskName)
    }

}
