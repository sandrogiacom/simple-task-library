package com.giacom.simpletask.controller

import com.giacom.simpletask.controller.mapper.TaskStepDefinitionMapper
import com.giacom.simpletask.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.service.FindTaskStepDefinitionService
import com.giacom.simpletask.service.TaskStepDefinitionService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskStepDefinitionController(
    private val service: TaskStepDefinitionService,
    private val findService: FindTaskStepDefinitionService,
    private val mapper: TaskStepDefinitionMapper
) {

    @PostMapping("/{taskDefinitionId}/steps")
    fun create(@Valid @RequestBody request: TaskStepDefinitionCreateRequest, @PathVariable taskDefinitionId: Long):
            ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = service.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @GetMapping("/{taskDefinitionId}/steps")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskStepDefinitionResponse>> {
        val taskStepDefinitions = findService.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(taskStepDefinitions))
    }

    @GetMapping("/steps/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = findService.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @PutMapping("/steps/{id}")
    fun updateStep(@PathVariable id: Long, @Valid @RequestBody request: TaskStepDefinitionCreateRequest):
            ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = service.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @DeleteMapping("/steps/{id}")
    fun deleteStep(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}
