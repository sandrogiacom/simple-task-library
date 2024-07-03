package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskAttributeDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskAttributeDefinitionConfig {

    @Bean
    fun saveTaskAttributeDefinitionInput(
        saveTaskAttributeDefinitionOutput: SaveTaskAttributeDefinitionOutput,
        findTaskAttributeDefinitionInput: FindTaskAttributeDefinitionInput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskAttributeDefinitionUseCase {
        return SaveTaskAttributeDefinitionUseCase(
            saveTaskAttributeDefinitionOutput,
            findTaskAttributeDefinitionInput,
            findTaskDefinitionInput
        )
    }

}
