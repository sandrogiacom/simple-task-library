package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.input.SaveTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskStepDefinitionOutput

class SaveTaskStepDefinitionUseCase(
    private val saveTaskStepDefinitionOutput: SaveTaskStepDefinitionOutput,
    private val findTaskStepDefinitionOutput: FindTaskStepDefinitionOutput,
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput
) : SaveTaskStepDefinitionInput {

    override fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskDefinition = findTaskDefinitionOutput.findById(taskDefinitionId)
            .orElseThrow { RuntimeException("Task definition not found") }
        return saveTaskStepDefinitionOutput.save(
            taskStepDefinition.copy(taskDefinition = taskDefinition)
        )

    }

    override fun update(id: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val existTaskStep = findTaskStepDefinitionOutput.findById(id)
            .orElseThrow { RuntimeException("Task step definition not found") }
        return saveTaskStepDefinitionOutput.save(
            taskStepDefinition.copy(
                id = existTaskStep.id,
                taskDefinition = existTaskStep.taskDefinition
            )
        )
    }

}
