package com.giacom.simpletask.persistence.entity

import jakarta.persistence.*

@Entity
data class TaskDefinitionJpa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @OneToMany(mappedBy = "taskDefinition", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tasks: List<TaskStepDefinitionJpa> = mutableListOf()
)
