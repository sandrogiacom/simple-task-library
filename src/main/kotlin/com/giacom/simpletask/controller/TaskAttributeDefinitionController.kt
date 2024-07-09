package com.giacom.simpletask.controller

import com.giacom.simpletask.controller.mapper.TaskAttributeDefinitionMapper
import com.giacom.simpletask.controller.request.TaskAttributeDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskAttributeDefinitionResponse
import com.giacom.simpletask.service.FindTaskAttributeDefinitionService
import com.giacom.simpletask.service.TaskAttributeDefinitionService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskAttributeDefinitionController(
    private val service: TaskAttributeDefinitionService,
    private val findService: FindTaskAttributeDefinitionService,
    private val mapper: TaskAttributeDefinitionMapper
) {

    @PostMapping("/{taskDefinitionId}/attributes")
    fun create(
        @Valid @RequestBody request: TaskAttributeDefinitionCreateRequest, @PathVariable taskDefinitionId: Long
    ): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = service.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @GetMapping("/{taskDefinitionId}/attributes")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskAttributeDefinitionResponse>> {
        val taskAttributeDefinitions = findService.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(taskAttributeDefinitions))
    }

    @GetMapping("/attributes/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = findService.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @PutMapping("/attributes/{id}")
    fun updateAttribute(
        @PathVariable id: Long,
        @Valid @RequestBody request: TaskAttributeDefinitionCreateRequest
    ): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = service.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @DeleteMapping("/attributes/{id}")
    fun deleteAttribute(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}
