package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.DeleteTaskStepDefinitionUseCase
import com.giacom.simpletask.application.core.usecase.FindTaskStepDefinitionUseCase
import com.giacom.simpletask.application.ports.output.DeleteTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteTaskStepDefinitionConfig {

    @Bean
    fun deleteTaskStepDefinitionInput(deleteTaskStepDefinitionOutput: DeleteTaskStepDefinitionOutput): DeleteTaskStepDefinitionUseCase {
        return DeleteTaskStepDefinitionUseCase(deleteTaskStepDefinitionOutput)
    }

}
