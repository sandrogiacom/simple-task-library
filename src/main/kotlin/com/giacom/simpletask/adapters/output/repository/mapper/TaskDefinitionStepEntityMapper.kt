package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionStepEntity
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskDefinitionStepEntityMapper {

    fun toEntity(taskStepDefinition: TaskDefinitionStep): TaskDefinitionStepEntity
    fun toDomain(taskStepDefinitionEntity: TaskDefinitionStepEntity): TaskDefinitionStep
}
