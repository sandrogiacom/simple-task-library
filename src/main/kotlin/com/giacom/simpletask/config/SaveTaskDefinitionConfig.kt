package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class SaveTaskDefinitionConfig {

    @Bean
    fun saveTaskDefinitionInput(
        saveTaskDefinitionOutput: SaveTaskDefinitionOutput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskDefinitionUseCase {
        return SaveTaskDefinitionUseCase(saveTaskDefinitionOutput, findTaskDefinitionInput)
    }

}
