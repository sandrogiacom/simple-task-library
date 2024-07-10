package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskAttributeInstance

interface SaveTaskAttributeInstanceOutput {
    fun save(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstance
}
