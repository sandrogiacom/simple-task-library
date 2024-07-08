package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskAttributeDefinitionUseCase
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskAttributeDefinitionConfig {

    @Bean
    fun findTaskAttributeDefinitionInput(findTaskAttributeDefinitionOutput: FindTaskAttributeDefinitionOutput): FindTaskAttributeDefinitionUseCase {
        return FindTaskAttributeDefinitionUseCase(findTaskAttributeDefinitionOutput)
    }

}
