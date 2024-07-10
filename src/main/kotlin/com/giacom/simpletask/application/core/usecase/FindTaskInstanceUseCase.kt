package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.output.FindTaskInstanceOutput

class FindTaskInstanceUseCase(
    private val findTaskInstanceOutput: FindTaskInstanceOutput
) : FindTaskInstanceInput {

    override fun findById(id: Long): TaskInstance {
        return findTaskInstanceOutput.findById(id)
    }
}
