package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskAttributeInstanceEntity
import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskAttributeInstanceEntityMapper {

    fun toEntity(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstanceEntity

    fun toDomain(taskAttributeInstanceEntity: TaskAttributeInstanceEntity): TaskAttributeInstance
}
