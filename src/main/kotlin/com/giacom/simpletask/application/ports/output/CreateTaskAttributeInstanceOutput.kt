package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskAttributeInstance

interface CreateTaskAttributeInstanceOutput {
    fun create(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstance
}
