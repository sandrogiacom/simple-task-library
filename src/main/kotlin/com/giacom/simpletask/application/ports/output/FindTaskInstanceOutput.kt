package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstance

interface FindTaskInstanceOutput {
    fun findById(id: Long): TaskInstance
}
