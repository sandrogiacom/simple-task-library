package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.InsertTaskDefinitionAdapter
import com.giacom.simpletask.application.core.usecase.CreateTaskDefinitionUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreateTaskDefinitionConfig {

    @Bean
    fun createTaskDefinitionInput(adapter: InsertTaskDefinitionAdapter): CreateTaskDefinitionUseCase {
        return CreateTaskDefinitionUseCase(adapter)
    }

}
