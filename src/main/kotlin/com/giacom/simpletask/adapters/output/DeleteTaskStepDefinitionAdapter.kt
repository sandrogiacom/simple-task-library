package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.application.ports.output.DeleteTaskStepDefinitionOutput
import org.springframework.stereotype.Component

@Component
class DeleteTaskStepDefinitionAdapter(
    private val repository: TaskStepDefinitionRepository
) : DeleteTaskStepDefinitionOutput {

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}
