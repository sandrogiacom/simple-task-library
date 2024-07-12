package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskDefinitionStepUseCase
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionStepOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class SaveTaskDefinitionStepConfig {

    @Bean
    fun saveTaskStepDefinitionInput(
        saveTaskStepDefinitionOutput: SaveTaskDefinitionStepOutput,
        findTaskStepDefinitionInput: FindTaskDefinitionStepInput,
        findTaskDefinitionInput: FindTaskDefinitionInput
    ): SaveTaskDefinitionStepUseCase {
        return SaveTaskDefinitionStepUseCase(saveTaskStepDefinitionOutput, findTaskStepDefinitionInput, findTaskDefinitionInput)
    }

}
