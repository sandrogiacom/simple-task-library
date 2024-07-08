package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskStepDefinitionUseCase
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskStepDefinitionConfig {

    @Bean
    fun findTaskStepDefinitionInput(findTaskStepDefinitionOutput: FindTaskStepDefinitionOutput): FindTaskStepDefinitionUseCase {
        return FindTaskStepDefinitionUseCase(findTaskStepDefinitionOutput)
    }

}
