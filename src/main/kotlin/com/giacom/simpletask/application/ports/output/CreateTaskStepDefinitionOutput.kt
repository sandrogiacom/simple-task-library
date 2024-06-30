package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskStepDefinition

interface CreateTaskStepDefinitionOutput {

    fun create(taskStepDefinition: TaskStepDefinition): TaskStepDefinition

}
