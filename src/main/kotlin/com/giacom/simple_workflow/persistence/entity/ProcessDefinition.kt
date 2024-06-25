package com.giacom.simple_workflow.persistence.entity

import jakarta.persistence.*

@Entity
data class ProcessDefinition(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @OneToMany(mappedBy = "process", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tasks: List<TaskDefinition> = mutableListOf()
)
