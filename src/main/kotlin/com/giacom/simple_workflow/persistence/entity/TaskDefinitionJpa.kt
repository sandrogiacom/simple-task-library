package com.giacom.simple_workflow.persistence.entity

import jakarta.persistence.*

@Entity
data class TaskDefinitionJpa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val description: String,
    @ManyToOne
    @JoinColumn(name = "process_id")
    val process: ProcessDefinitionJpa,
    val handler: String? = null
)