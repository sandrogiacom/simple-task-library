package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.SaveTaskStepDefinitionUseCase
import com.giacom.simpletask.application.ports.output.SaveTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaveTaskStepDefinitionConfig {

    @Bean
    fun saveTaskStepDefinitionInput(
        saveTaskStepDefinitionOutput: SaveTaskStepDefinitionOutput,
        findTaskStepDefinitionOutput: FindTaskStepDefinitionOutput,
        findTaskDefinitionOutput: FindTaskDefinitionOutput
    ): SaveTaskStepDefinitionUseCase {
        return SaveTaskStepDefinitionUseCase(saveTaskStepDefinitionOutput, findTaskStepDefinitionOutput, findTaskDefinitionOutput)
    }

}
