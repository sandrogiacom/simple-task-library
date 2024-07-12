package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.DeleteTaskDefinitionAttributeUseCase
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionAttributeOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class DeleteTaskDefinitionAttributeConfig {

    @Bean
    fun deleteTaskAttributeDefinitionInput(deleteTaskAttributeDefinitionOutput: DeleteTaskDefinitionAttributeOutput): DeleteTaskDefinitionAttributeUseCase {
        return DeleteTaskDefinitionAttributeUseCase(deleteTaskAttributeDefinitionOutput)
    }

}