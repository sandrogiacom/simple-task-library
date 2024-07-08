package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.DeleteTaskStepDefinitionUseCase
import com.giacom.simpletask.application.ports.output.DeleteTaskStepDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class DeleteTaskStepDefinitionConfig {

    @Bean
    fun deleteTaskStepDefinitionInput(deleteTaskStepDefinitionOutput: DeleteTaskStepDefinitionOutput): DeleteTaskStepDefinitionUseCase {
        return DeleteTaskStepDefinitionUseCase(deleteTaskStepDefinitionOutput)
    }

}
