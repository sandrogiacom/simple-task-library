package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionStepUseCase
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionStepOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskDefinitionStepConfig {

    @Bean
    fun findTaskDefinitionStepInput(findTaskDefinitionStepOutput: FindTaskDefinitionStepOutput): FindTaskDefinitionStepUseCase {
        return FindTaskDefinitionStepUseCase(findTaskDefinitionStepOutput)
    }

}
