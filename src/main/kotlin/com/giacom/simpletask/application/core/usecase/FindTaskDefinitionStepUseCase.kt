package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionStepOutput

class FindTaskDefinitionStepUseCase(
    private val findTaskDefinitionStepOutput: FindTaskDefinitionStepOutput
) : FindTaskDefinitionStepInput {

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStep> {
        return findTaskDefinitionStepOutput.findAllByTaskDefinitionId(taskDefinitionId)
    }

    override fun findById(id: Long): TaskDefinitionStep {
        return findTaskDefinitionStepOutput.findById(id).orElseThrow { RuntimeException("Task definition step not found") }
    }

    override fun findByStepName(stepName: String): TaskDefinitionStep {
        return findTaskDefinitionStepOutput.findByStepName(stepName)
    }


}
