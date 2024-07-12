package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionAttributeUseCase
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionAttributeOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskDefinitionAttributeConfig {

    @Bean
    fun taskDefinitionAttributeInput(findTaskDefinitionAttributeOutput: FindTaskDefinitionAttributeOutput): FindTaskDefinitionAttributeUseCase {
        return FindTaskDefinitionAttributeUseCase(findTaskDefinitionAttributeOutput)
    }

}
