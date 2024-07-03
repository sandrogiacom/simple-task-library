package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskStepDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskStepDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskStepDefinitionConfig {

    @Bean
    fun saveTaskStepDefinitionInput(
        saveTaskStepDefinitionOutput: SaveTaskStepDefinitionOutput,
        findTaskStepDefinitionInput: FindTaskStepDefinitionInput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskStepDefinitionUseCase {
        return SaveTaskStepDefinitionUseCase(saveTaskStepDefinitionOutput, findTaskStepDefinitionInput, findTaskDefinitionInput)
    }

}
