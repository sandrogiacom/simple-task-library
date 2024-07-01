package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.SaveTaskDefinitionAdapter
import com.giacom.simpletask.application.core.usecase.SaveTaskDefinitionUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskDefinitionConfig {

    @Bean
    fun saveTaskDefinitionInput(adapter: SaveTaskDefinitionAdapter): SaveTaskDefinitionUseCase {
        return SaveTaskDefinitionUseCase(adapter)
    }

}
