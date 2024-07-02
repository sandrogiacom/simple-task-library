package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.application.ports.output.DeleteTaskAttributeDefinitionOutput
import org.springframework.stereotype.Component

@Component
class DeleteTaskAttributeDefinitionAdapter(
    private val repository: TaskAttributeDefinitionRepository
) : DeleteTaskAttributeDefinitionOutput {

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}
