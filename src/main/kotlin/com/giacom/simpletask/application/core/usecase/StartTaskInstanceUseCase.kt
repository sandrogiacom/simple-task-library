package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.input.StartTaskInstanceInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput

class StartTaskInstanceUseCase(
    private val findTaskInstanceInput: FindTaskInstanceInput,
    private val taskInstanceOutput: SaveTaskInstanceOutput
) : StartTaskInstanceInput {

    override fun startTask(taskInstanceId: Long): TaskInstance {
        val taskInstance = findTaskInstanceInput.findById(taskInstanceId)
        val started = taskInstance.startTask()
        taskInstanceOutput.save(started)
        return started
    }

}
