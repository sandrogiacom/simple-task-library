package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.CreateTaskStepDefinitionAdapter
import com.giacom.simpletask.application.core.usecase.CreateTaskStepDefinitionUseCase
import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreateTaskStepDefinitionConfig {

    @Bean
    fun createTaskStepDefinitionInput(adapter: CreateTaskStepDefinitionAdapter,
           findTaskDefinitionOutput: FindTaskDefinitionOutput): CreateTaskStepDefinitionUseCase {
        return CreateTaskStepDefinitionUseCase(adapter, findTaskDefinitionOutput)
    }

}
