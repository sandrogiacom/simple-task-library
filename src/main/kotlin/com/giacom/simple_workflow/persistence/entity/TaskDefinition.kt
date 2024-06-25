package com.giacom.simple_workflow.persistence.entity

import jakarta.persistence.*

@Entity
data class TaskDefinition(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "process_id")
    val process: ProcessDefinition,
    val handler: String? = null
)