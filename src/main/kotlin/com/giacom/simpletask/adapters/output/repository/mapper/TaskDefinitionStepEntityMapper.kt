package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionStepEntity
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskDefinitionStepEntityMapper {

    fun toEntity(taskDefinitionStep: TaskDefinitionStep): TaskDefinitionStepEntity
    fun toDomain(taskDefinitionStepEntity: TaskDefinitionStepEntity): TaskDefinitionStep
}
