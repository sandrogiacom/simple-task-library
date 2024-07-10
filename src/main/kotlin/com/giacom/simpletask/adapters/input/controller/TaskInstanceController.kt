package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskInstanceMapper
import com.giacom.simpletask.adapters.input.controller.response.TaskInstanceResponse
import com.giacom.simpletask.application.ports.input.CreateTaskInstanceInput
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.input.StartTaskInstanceInput
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-instance/")
class TaskInstanceController(
    private val createTaskInstanceInput: CreateTaskInstanceInput,
    private val startTaskInstanceInput: StartTaskInstanceInput,
    private val findTaskInstanceInput: FindTaskInstanceInput,
    private val mapper: TaskInstanceMapper
) {

    @PostMapping("/create")
    fun create(@Valid @NotBlank taskName: String): ResponseEntity<TaskInstanceResponse> {
        val response = createTaskInstanceInput.create(taskName)
        return ResponseEntity.ok(mapper.toTaskInstanceResponse(response))
    }

    @PostMapping("/{id}/start/")
    fun start(@PathVariable id: Long): ResponseEntity<TaskInstanceResponse> {
        val response = startTaskInstanceInput.startTask(id)
        return ResponseEntity.ok(mapper.toTaskInstanceResponse(response))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskInstanceResponse> {
        val response = findTaskInstanceInput.findById(id)
        return ResponseEntity.ok(mapper.toTaskInstanceResponse(response))
    }

}
