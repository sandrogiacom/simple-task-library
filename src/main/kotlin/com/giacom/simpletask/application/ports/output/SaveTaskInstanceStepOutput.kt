package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstanceStep

interface SaveTaskInstanceStepOutput {
    fun save(taskStepInstance: TaskInstanceStep): TaskInstanceStep
}
