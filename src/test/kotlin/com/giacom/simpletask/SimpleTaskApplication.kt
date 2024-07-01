package com.giacom.simpletask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.ActiveProfiles

@SpringBootApplication
class SimpleTaskApplication

fun main(args: Array<String>) {
	runApplication<SimpleTaskApplication>(*args)
}
