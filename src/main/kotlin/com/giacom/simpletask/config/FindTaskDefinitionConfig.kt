package com.giacom.simpletask.config

import com.giacom.simpletask.adapters.output.FindTaskDefinitionAdapter
import com.giacom.simpletask.adapters.output.repository.TaskDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.application.core.usecase.FindTaskDefinitionUseCase
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskDefinitionConfig {

    @Bean
    fun findTaskDefinitionInput(
        findTaskDefinitionOutput: FindTaskDefinitionOutput,
        findTaskStepDefinitionInput: FindTaskStepDefinitionInput,
        findTaskAttributeDefinitionInput: FindTaskAttributeDefinitionInput
    ): FindTaskDefinitionInput {
        return FindTaskDefinitionUseCase(findTaskDefinitionOutput, findTaskStepDefinitionInput, findTaskAttributeDefinitionInput)
    }

}
