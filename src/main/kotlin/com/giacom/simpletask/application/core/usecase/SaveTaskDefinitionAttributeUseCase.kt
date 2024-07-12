package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionAttributeOutput

class SaveTaskDefinitionAttributeUseCase(
    private val saveTaskAttributeDefinitionOutput: SaveTaskDefinitionAttributeOutput,
    private val findTaskAttributeDefinitionInput: FindTaskDefinitionAttributeInput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskDefinitionAttributeInput {

    override fun create(taskDefinitionId: Long, taskAttributeDefinition: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val taskDefinition = findTaskDefinitionInput.findById(taskDefinitionId)
        try {
            val existTaskAttribute = findTaskAttributeDefinitionInput.findByAttributeName(taskAttributeDefinition.attributeName)
            if (existTaskAttribute != null) {
                throw RuntimeException("Task definition Attribute already exists!")
            }
        } catch (ex: NoSuchElementException) {
            //nothing to do
        } catch (ex: Exception) {
            throw ex
        }
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(taskDefinition = taskDefinition)
        )
    }

    override fun update(id: Long, taskAttributeDefinition: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val existTaskAttribute = findTaskAttributeDefinitionInput.findById(id)
        return saveTaskAttributeDefinitionOutput.save(
            taskAttributeDefinition.copy(
                id = existTaskAttribute.id,
                taskDefinition = existTaskAttribute.taskDefinition
            )
        )
    }

}
