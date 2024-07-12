package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionAttributeOutput

class SaveTaskDefinitionAttributeUseCase(
    private val saveTaskDefinitionAttributeOutput: SaveTaskDefinitionAttributeOutput,
    private val findTaskDefinitionAttributeInput: FindTaskDefinitionAttributeInput,
    private val findTaskDefinitionInput: FindTaskDefinitionInput
) : SaveTaskDefinitionAttributeInput {

    override fun create(taskDefinitionId: Long, taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val taskDefinition = findTaskDefinitionInput.findById(taskDefinitionId)
        try {
            val existTaskAttribute = findTaskDefinitionAttributeInput.findByAttributeName(taskDefinitionAttribute.attributeName)
            if (existTaskAttribute != null) {
                throw RuntimeException("Task definition Attribute already exists!")
            }
        } catch (ex: NoSuchElementException) {
            //nothing to do
        } catch (ex: Exception) {
            throw ex
        }
        return saveTaskDefinitionAttributeOutput.save(
            taskDefinitionAttribute.copy(taskDefinition = taskDefinition)
        )
    }

    override fun update(id: Long, taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val existTaskAttribute = findTaskDefinitionAttributeInput.findById(id)
        return saveTaskDefinitionAttributeOutput.save(
            taskDefinitionAttribute.copy(
                id = existTaskAttribute.id,
                taskDefinition = existTaskAttribute.taskDefinition
            )
        )
    }

}
