package com.giacom.simpletask.adapters.output.repository.entity

import com.giacom.simpletask.application.core.domain.TaskStatus
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
    @Enumerated(EnumType.STRING)
    val status: TaskStatus,
    val startedAt: LocalDateTime? = null,
    val completedAt: LocalDateTime? = null,
)
