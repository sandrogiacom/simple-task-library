package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.TaskStepInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeDefinitionEntityMapper
import com.giacom.simpletask.adapters.output.repository.mapper.TaskStepInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.output.CreateTaskAttributeInstanceOutput
import com.giacom.simpletask.application.ports.output.CreateTaskStepInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateTaskStepInstanceAdapter(
    private val repository: TaskStepInstanceRepository,
    private val mapper: TaskStepInstanceEntityMapper
) : CreateTaskStepInstanceOutput {

    override fun create(taskStepInstance: TaskStepInstance): TaskStepInstance {
        TODO("Not yet implemented")
    }


}
