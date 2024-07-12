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
    fun saveTaskDefinitionAttributeInput(
        saveTaskDefinitionAttributeOutput: SaveTaskDefinitionAttributeOutput,
        findTaskDefinitionAttributeInput: FindTaskDefinitionAttributeInput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskDefinitionAttributeUseCase {
        return SaveTaskDefinitionAttributeUseCase(
            saveTaskDefinitionAttributeOutput,
            findTaskDefinitionAttributeInput,
            findTaskDefinitionInput
        )
    }

}
