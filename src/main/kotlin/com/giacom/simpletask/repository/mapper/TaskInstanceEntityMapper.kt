package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskInstance
import com.giacom.simpletask.repository.entity.TaskInstanceEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskInstanceEntityMapper {

    fun toEntity(taskInstance: TaskInstance): TaskInstanceEntity

    fun toDomain(taskInstanceEntity: TaskInstanceEntity): TaskInstance
}
