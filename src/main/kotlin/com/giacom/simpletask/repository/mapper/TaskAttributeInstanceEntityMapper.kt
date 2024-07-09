package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskAttributeInstance
import com.giacom.simpletask.repository.entity.TaskAttributeInstanceEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskAttributeInstanceEntityMapper {

    fun toEntity(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstanceEntity

    fun toDomain(taskAttributeInstanceEntity: TaskAttributeInstanceEntity): TaskAttributeInstance
}
