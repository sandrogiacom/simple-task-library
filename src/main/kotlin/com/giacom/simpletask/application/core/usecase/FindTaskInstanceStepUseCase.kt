package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.ports.input.FindTaskInstanceStepInput
import com.giacom.simpletask.application.ports.output.FindTaskInstanceStepOutput

class FindTaskInstanceStepUseCase(
    private val findTaskInstanceStepOutput: FindTaskInstanceStepOutput
) : FindTaskInstanceStepInput {

    override fun findAllByTaskInstanceId(taskInstanceId: Long): List<TaskInstanceStep> {
        return findTaskInstanceStepOutput.findAllByTaskInstanceId(taskInstanceId)
    }

}
