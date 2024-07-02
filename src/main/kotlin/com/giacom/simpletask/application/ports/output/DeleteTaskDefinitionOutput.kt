package com.giacom.simpletask.application.ports.output

interface DeleteTaskDefinitionOutput {
    fun deleteById(id: Long)
}
