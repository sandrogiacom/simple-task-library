package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstance

interface SaveTaskInstanceOutput {
    fun save(taskInstance: TaskInstance): TaskInstance
}
