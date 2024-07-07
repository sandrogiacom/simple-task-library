package com.giacom.simpletask.adapters.output.repository.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_instance")
data class TaskInstanceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "task_definition_id")
    val taskDefinition: TaskDefinitionEntity,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)
