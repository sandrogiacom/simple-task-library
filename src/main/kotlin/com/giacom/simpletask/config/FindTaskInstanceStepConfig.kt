package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.FindTaskInstanceStepUseCase
import com.giacom.simpletask.application.ports.output.FindTaskInstanceStepOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class FindTaskInstanceStepConfig {

    @Bean
    fun findTaskInstanceStepInput(
        findTaskInstanceStepOutput: FindTaskInstanceStepOutput
    ): FindTaskInstanceStepUseCase {
        return FindTaskInstanceStepUseCase(findTaskInstanceStepOutput)
    }

}
