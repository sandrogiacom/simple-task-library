package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskDefinitionAttributeUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionAttributeOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class SaveTaskDefinitionAttributeConfig {

    @Bean
    fun saveTaskAttributeDefinitionInput(
        saveTaskAttributeDefinitionOutput: SaveTaskDefinitionAttributeOutput,
        findTaskAttributeDefinitionInput: FindTaskDefinitionAttributeInput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskDefinitionAttributeUseCase {
        return SaveTaskDefinitionAttributeUseCase(
            saveTaskAttributeDefinitionOutput,
            findTaskAttributeDefinitionInput,
            findTaskDefinitionInput
        )
    }

}
