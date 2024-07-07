package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.application.ports.input.CreateTaskInstanceInput
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task-instance/")
class CreateTaskInstanceController(
    private val createTaskInstanceInput: CreateTaskInstanceInput
) {

    @PostMapping
    fun create(@Valid @NotBlank taskName: String): ResponseEntity<Long> {
        val id = createTaskInstanceInput.create(taskName)
        return ResponseEntity.ok(id)
    }

}
