package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskInstanceUseCase
import com.giacom.simpletask.application.ports.input.FindTaskInstanceStepInput
import com.giacom.simpletask.application.ports.output.FindTaskInstanceOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskInstanceConfig {

    @Bean
    fun findTaskInstanceInput(
        findTaskInstanceOutput: FindTaskInstanceOutput,
        findTaskInstanceStepInput: FindTaskInstanceStepInput
    ): FindTaskInstanceUseCase {
        return FindTaskInstanceUseCase(findTaskInstanceOutput, findTaskInstanceStepInput)
    }

}
