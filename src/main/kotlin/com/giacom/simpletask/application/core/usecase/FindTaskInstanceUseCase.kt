package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.input.FindTaskInstanceStepInput
import com.giacom.simpletask.application.ports.output.FindTaskInstanceOutput

class FindTaskInstanceUseCase(
    private val findTaskInstanceOutput: FindTaskInstanceOutput,
    private val findTaskInstanceStepInput: FindTaskInstanceStepInput
) : FindTaskInstanceInput {

    override fun findById(id: Long): TaskInstance {
        val taskInstance = findTaskInstanceOutput.findById(id)
        val taskInstanceSteps = findTaskInstanceStepInput.findAllByTaskInstanceId(id)
        taskInstanceSteps.forEach {
            taskInstance.addStep(it)
        }
        return taskInstance
    }
}
