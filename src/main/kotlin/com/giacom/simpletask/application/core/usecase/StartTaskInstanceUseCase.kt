package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.input.StartTaskInstanceInput

class StartTaskInstanceUseCase(
    private val findTaskInstanceInput: FindTaskInstanceInput
) : StartTaskInstanceInput {

    override fun startTask(taskInstanceId: Long): TaskInstance {
        val taskInstance = findTaskInstanceInput.findById(taskInstanceId)
        taskInstance.startTask()

        return taskInstance
    }

}
