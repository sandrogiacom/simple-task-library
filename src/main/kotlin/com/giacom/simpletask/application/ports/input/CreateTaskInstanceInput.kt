package com.giacom.simpletask.application.ports.input

interface CreateTaskInstanceInput {
    fun create(taskName: String): Long
}
