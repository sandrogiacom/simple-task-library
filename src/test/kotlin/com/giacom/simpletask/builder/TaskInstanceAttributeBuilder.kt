package com.giacom.simpletask.builder

import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute

data class TaskInstanceAttributeBuilder(
    val id: Long = 0,
    val attributeName: String = "",
    val attributeValue: String? = "",
    val taskInstanceId: Long = 0
) {
    fun build(): TaskInstanceAttribute {
        return TaskInstanceAttribute(
            id = id,
            attributeName = attributeName,
            attributeValue = attributeValue,
            taskInstanceId = taskInstanceId
        )
    }
}
