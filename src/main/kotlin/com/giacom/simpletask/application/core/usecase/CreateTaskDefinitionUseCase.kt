package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.input.CreateTaskDefinitionInput

import com.giacom.simpletask.application.ports.out.CreateTaskDefinitionOutput

class CreateTaskDefinitionUseCase(
    private val createTaskDefinitionOutput: CreateTaskDefinitionOutput
) : CreateTaskDefinitionInput {

    override fun create(taskDefinition: TaskDefinition): TaskDefinition {
        return createTaskDefinitionOutput.create(taskDefinition)
    }

}
