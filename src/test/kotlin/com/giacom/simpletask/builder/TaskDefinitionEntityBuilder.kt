package com.giacom.simpletask.builder

import com.giacom.simpletask.repository.entity.TaskDefinitionEntity

data class TaskDefinitionEntityBuilder(
    val id: Long = 0,
    val taskName: String = "",
    val taskDescription: String = ""
) {
    fun build(): TaskDefinitionEntity {
        return TaskDefinitionEntity(
            id = id,
            taskName = taskName,
            taskDescription = taskDescription
        )
    }

}
