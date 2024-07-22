package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute

data class TaskDefinitionAttributeBuilder(
    val id: Long? = 0,
    val attributeName: String = "",
    val taskDefinition: TaskDefinition
) {
    fun build(): TaskDefinitionAttribute {
        return TaskDefinitionAttribute(
            id = id,
            attributeName = attributeName,
            taskDefinition = taskDefinition
        )
    }

    fun withId(id: Long): TaskDefinitionAttributeBuilder {
        return this.copy(id = id)
    }

    fun withAttributeName(attributeName: String): TaskDefinitionAttributeBuilder {
        return this.copy(attributeName = attributeName)
    }
}

