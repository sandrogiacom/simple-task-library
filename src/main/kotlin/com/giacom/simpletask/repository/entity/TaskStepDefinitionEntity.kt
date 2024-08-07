package com.giacom.simpletask.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "task_step_definition")
data class TaskStepDefinitionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val stepName: String,
    val stepDescription: String,
    val stepNumber: Int,
    @ManyToOne
    @JoinColumn(name = "task_definition_id")
    val taskDefinition: TaskDefinitionEntity,
    val stepHandler: String? = null
)
