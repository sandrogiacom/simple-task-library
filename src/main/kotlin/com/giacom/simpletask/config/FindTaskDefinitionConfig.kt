package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskDefinitionConfig {

    @Bean
    fun findTaskDefinitionInput(
        findTaskDefinitionOutput: FindTaskDefinitionOutput,
        findTaskStepDefinitionInput: FindTaskDefinitionStepInput,
        findTaskAttributeDefinitionInput: FindTaskDefinitionAttributeInput
    ): FindTaskDefinitionInput {
        return FindTaskDefinitionUseCase(findTaskDefinitionOutput, findTaskStepDefinitionInput, findTaskAttributeDefinitionInput)
    }

}
