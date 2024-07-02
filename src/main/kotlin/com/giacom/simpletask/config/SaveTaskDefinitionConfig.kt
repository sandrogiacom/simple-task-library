package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskDefinitionConfig {

    @Bean
    fun saveTaskDefinitionInput(
        saveTaskDefinitionOutput: SaveTaskDefinitionOutput,
        findTaskDefinitionOutput: FindTaskDefinitionOutput
    ): SaveTaskDefinitionUseCase {
        return SaveTaskDefinitionUseCase(saveTaskDefinitionOutput, findTaskDefinitionOutput)
    }

}
