package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskInstance

interface CreateTaskInstanceInput {
    fun create(taskName: String): TaskInstance
}
