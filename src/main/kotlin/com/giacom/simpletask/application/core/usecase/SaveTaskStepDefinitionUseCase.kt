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
        //TODO: poderia ter um indice unico no banco para evitar a exceção. stepName + taskDefinitionId
        //TODO: verificar se a ordem ja existe para a taskDefinitionId
        try {
            val existTaskStep = findTaskStepDefinitionInput.findByStepName(taskStepDefinition.stepName)
            if (existTaskStep != null) {
                throw RuntimeException("Task definition Step already exists!")
            }
        } catch (ex: NoSuchElementException) {
            //nothing to do
        } catch (ex: Exception) {
            throw ex
        }

        //TODO: validate attributes

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
