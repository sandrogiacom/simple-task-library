package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.CreateTaskInstanceUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceStepOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class CreateTaskInstanceConfig {

    @Bean
    fun createTaskInstanceInput(
        findTaskDefinitionInput: FindTaskDefinitionInput,
        createTaskInstanceOutput: SaveTaskInstanceOutput,
        createTaskStepInstanceOutput: SaveTaskInstanceStepOutput,
        createTaskAttributeInstanceOutput: SaveTaskInstanceAttributeOutput
    ): CreateTaskInstanceUseCase {
        return CreateTaskInstanceUseCase(
            findTaskDefinitionInput,
            createTaskInstanceOutput,
            createTaskStepInstanceOutput,
            createTaskAttributeInstanceOutput
        )
    }

}
