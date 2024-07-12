package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.DeleteTaskDefinitionStepUseCase
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionStepOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class DeleteTaskDefinitionStepConfig {

    @Bean
    fun deleteTaskStepDefinitionInput(deleteTaskStepDefinitionOutput: DeleteTaskDefinitionStepOutput): DeleteTaskDefinitionStepUseCase {
        return DeleteTaskDefinitionStepUseCase(deleteTaskStepDefinitionOutput)
    }

}
