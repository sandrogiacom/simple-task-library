package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.DeleteTaskAttributeDefinitionUseCase
import com.giacom.simpletask.application.ports.output.DeleteTaskAttributeDefinitionOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class DeleteTaskAttributeDefinitionConfig {

    @Bean
    fun deleteTaskAttributeDefinitionInput(deleteTaskAttributeDefinitionOutput: DeleteTaskAttributeDefinitionOutput): DeleteTaskAttributeDefinitionUseCase {
        return DeleteTaskAttributeDefinitionUseCase(deleteTaskAttributeDefinitionOutput)
    }

}
