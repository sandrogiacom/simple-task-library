package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionStepOutput

class SaveTaskDefinitionStepUseCase(
    private val saveTaskStepDefinitionOutput: SaveTaskDefinitionStepOutput,
    private val findTaskStepDefinitionInput: FindTaskDefinitionStepInput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskDefinitionStepInput {

    override fun create(taskDefinitionId: Long, taskStepDefinition: TaskDefinitionStep): TaskDefinitionStep {
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

    override fun update(id: Long, taskStepDefinition: TaskDefinitionStep): TaskDefinitionStep {
        val existTaskStep = findTaskStepDefinitionInput.findById(id)
        return saveTaskStepDefinitionOutput.save(
            taskStepDefinition.copy(
                id = existTaskStep.id,
                taskDefinition = existTaskStep.taskDefinition
            )
        )
    }

}