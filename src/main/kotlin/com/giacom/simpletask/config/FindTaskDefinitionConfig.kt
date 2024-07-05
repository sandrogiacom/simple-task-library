package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.FindTaskDefinitionAdapter
import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindTaskDefinitionConfig {

    @Bean
    fun findTaskDefinitionInput(
        adapter: FindTaskDefinitionAdapter,
        findTaskStepDefinitionInput: FindTaskStepDefinitionInput,
        findTaskAttributeDefinitionInput: FindTaskAttributeDefinitionInput
    ): FindTaskDefinitionInput {
        return FindTaskDefinitionUseCase(adapter, findTaskStepDefinitionInput, findTaskAttributeDefinitionInput)
    }

}
