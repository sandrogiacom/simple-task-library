package com.giacom.simpletask.controller

import com.giacom.simpletask.controller.mapper.TaskDefinitionMapper
import com.giacom.simpletask.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.service.FindTaskDefinitionService
import com.giacom.simpletask.service.TaskDefinitionService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions")
class TaskDefinitionController(
    private val service: TaskDefinitionService,
    private val findService: FindTaskDefinitionService,
    private val mapper: TaskDefinitionMapper
) {

    @PostMapping
    fun create(@Valid @RequestBody request: TaskDefinitionCreateRequest): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = service.create(mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = findService.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<TaskDefinitionResponse>> {
        val taskDefinitions = findService.findAll()
        return ResponseEntity.ok(mapper.toResponseList(taskDefinitions))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: TaskDefinitionCreateRequest): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = service.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}
