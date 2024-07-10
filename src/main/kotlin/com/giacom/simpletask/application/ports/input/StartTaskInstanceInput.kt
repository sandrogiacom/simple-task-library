package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskInstance

interface StartTaskInstanceInput {
    fun startTask(taskInstanceId: Long, attributes: Map<String, String>? = emptyMap()): TaskInstance
}
