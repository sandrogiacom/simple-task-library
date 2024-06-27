package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition

data class TaskDefinitionBuilder(
    val id: Long = 0,
    val taskName: String = "",
    val taskDescription: String = ""
) {
    fun build(): TaskDefinition {
        return TaskDefinition(
            id = id,
            taskName = taskName,
            taskDescription = taskDescription
        )
    }

}
