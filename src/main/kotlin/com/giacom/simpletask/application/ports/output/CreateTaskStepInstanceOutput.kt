package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskStepInstance

interface CreateTaskStepInstanceOutput {
    fun create(taskStepInstance: TaskStepInstance): TaskStepInstance
}
