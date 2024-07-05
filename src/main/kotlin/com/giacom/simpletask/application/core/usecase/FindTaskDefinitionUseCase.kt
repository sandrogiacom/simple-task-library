package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput

class FindTaskDefinitionUseCase(
    private val findTaskDefinitionOutput: FindTaskDefinitionOutput,
    private val findTaskStepDefinitionInput: FindTaskStepDefinitionInput,
    private val findTaskAttributeDefinitionInput: FindTaskAttributeDefinitionInput
) : FindTaskDefinitionInput {

    override fun findById(id: Long): TaskDefinition {
        val taskDefinition = findTaskDefinitionOutput.findById(id)
        return taskDefinition.also { withRelations(it) }
    }

    override fun findAll(): List<TaskDefinition> {
        return findTaskDefinitionOutput.findAll()
    }

    override fun findByName(name: String): TaskDefinition {
        val findByName = findTaskDefinitionOutput.findByName(name)
        return findByName.also { withRelations(it) }
    }

    private fun withRelations(taskDefinition: TaskDefinition) {
        withSteps(taskDefinition)
        withAttributes(taskDefinition)
    }

    private fun withSteps(taskDefinition: TaskDefinition) {
        taskDefinition.taskSteps = findTaskStepDefinitionInput.findAllByTaskDefinitionId(taskDefinition.id!!)
    }

    private fun withAttributes(taskDefinition: TaskDefinition) {
        taskDefinition.attributes = findTaskAttributeDefinitionInput.findAllByTaskDefinitionId(taskDefinition.id!!)
    }

}
