package com.giacom.simpletask.adapters.out.repository.entity

import jakarta.persistence.*

@Entity
data class TaskStepDefinitionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val stepName: String,
    val stepDescription: String,
    @ManyToOne
    val taskDefinition: TaskDefinitionEntity,
    val stepHandler: String? = null
)
