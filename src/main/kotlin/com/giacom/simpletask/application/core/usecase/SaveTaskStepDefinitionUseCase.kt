package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskStepDefinitionOutput

class SaveTaskStepDefinitionUseCase(
    private val saveTaskStepDefinitionOutput: SaveTaskStepDefinitionOutput,
    private val findTaskStepDefinitionInput: FindTaskStepDefinitionInput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskStepDefinitionInput {

    override fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskDefinition = findTaskDefinitionInput.findById(taskDefinitionId)
        return saveTaskStepDefinitionOutput.save(
            taskStepDefinition.copy(taskDefinition = taskDefinition)
        )
    }

    override fun update(id: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val existTaskStep = findTaskStepDefinitionInput.findById(id)
        return saveTaskStepDefinitionOutput.save(
            taskStepDefinition.copy(
                id = existTaskStep.id,
                taskDefinition = existTaskStep.taskDefinition
            )
        )
    }

}
