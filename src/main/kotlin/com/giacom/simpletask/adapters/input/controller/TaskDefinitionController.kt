package com.giacom.simpletask.adapters.`in`.controller

import com.giacom.simpletask.adapters.`in`.controller.mapper.TaskDefinitionMapper
import com.giacom.simpletask.adapters.`in`.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.adapters.`in`.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.application.ports.input.CreateTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions")
class TaskDefinitionController(
    private val createInput: CreateTaskDefinitionInput,
    private val findInput: FindTaskDefinitionInput,
    private val mapper: TaskDefinitionMapper
) {

    @PostMapping
    fun create(@Valid @RequestBody request: TaskDefinitionCreateRequest): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = createInput.create(mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = findInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

}
