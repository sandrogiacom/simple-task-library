package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskInstance

interface FindTaskInstanceInput {
    fun findById(id: Long): TaskInstance
}
