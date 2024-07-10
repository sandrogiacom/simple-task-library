package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskStepInstance

interface SaveTaskStepInstanceOutput {
    fun save(taskStepInstance: TaskStepInstance): TaskStepInstance
}
