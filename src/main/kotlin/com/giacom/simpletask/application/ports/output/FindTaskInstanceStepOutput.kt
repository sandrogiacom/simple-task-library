package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskInstanceStep

interface FindTaskInstanceStepOutput {
    fun findAllByTaskInstanceId(taskInstanceId: Long): List<TaskInstanceStep>
}
