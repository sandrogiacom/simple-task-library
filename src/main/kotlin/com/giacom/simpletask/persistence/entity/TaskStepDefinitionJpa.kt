package com.giacom.simpletask.persistence.entity

import jakarta.persistence.*

@Entity
data class TaskStepDefinitionJpa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val description: String,
    @ManyToOne
    @JoinColumn(name = "task_definition_id")
    val taskDefinition: TaskDefinitionJpa,
    val handler: String? = null
)
