package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstance

interface CreateTaskInstanceOutput {
    fun create(taskInstance: TaskInstance): TaskInstance
}
