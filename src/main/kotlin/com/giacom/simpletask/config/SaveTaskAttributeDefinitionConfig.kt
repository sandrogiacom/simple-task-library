package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskAttributeDefinitionUseCase
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskAttributeDefinitionConfig {

    @Bean
    fun saveTaskAttributeDefinitionInput(
        saveTaskAttributeDefinitionOutput: SaveTaskAttributeDefinitionOutput,
        findTaskAttributeDefinitionOutput: FindTaskAttributeDefinitionOutput,
        findTaskDefinitionOutput: FindTaskDefinitionOutput
    ): SaveTaskAttributeDefinitionUseCase {
        return SaveTaskAttributeDefinitionUseCase(saveTaskAttributeDefinitionOutput, findTaskAttributeDefinitionOutput, findTaskDefinitionOutput)
    }

}
