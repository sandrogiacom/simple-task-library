package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.FindTaskDefinitionAdapter
import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindTaskDefinitionConfig {

    @Bean
    fun findTaskDefinitionInput(adapter: FindTaskDefinitionAdapter): FindTaskDefinitionUseCase {
        return FindTaskDefinitionUseCase(adapter)
    }

}
