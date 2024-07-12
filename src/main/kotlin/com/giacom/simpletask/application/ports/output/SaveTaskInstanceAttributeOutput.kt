package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute

interface SaveTaskInstanceAttributeOutput {
    fun save(taskAttributeInstance: TaskInstanceAttribute): TaskInstanceAttribute
}
