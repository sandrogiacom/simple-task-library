package com.giacom.simpletask.config

import com.giacom.simpletask.application.core.usecase.StartTaskInstanceUseCase
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
class StartTaskInstanceConfig {

    @Bean
    fun startTaskInstanceInput(
        findTaskInstanceInput: FindTaskInstanceInput,
        taskInstanceOutput: SaveTaskInstanceOutput
    ): StartTaskInstanceUseCase {
        return StartTaskInstanceUseCase(findTaskInstanceInput, taskInstanceOutput)
    }

}
