package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.CreateTaskInstanceUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.CreateTaskAttributeInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskStepInstanceOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class CreateTaskInstanceConfig {

    @Bean
    fun createTaskInstanceInput(
        findTaskDefinitionInput: FindTaskDefinitionInput,
        createTaskInstanceOutput: CreateTaskInstanceOutput,
        createTaskStepInstanceOutput: CreateTaskStepInstanceOutput,
        createTaskAttributeInstanceOutput: CreateTaskAttributeInstanceOutput
    ): CreateTaskInstanceUseCase {
        return CreateTaskInstanceUseCase(
            findTaskDefinitionInput,
            createTaskInstanceOutput,
            createTaskStepInstanceOutput,
            createTaskAttributeInstanceOutput
        )
    }

}
