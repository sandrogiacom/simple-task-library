package com.giacom.simpletask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleTaskApplication

fun main(args: Array<String>) {
	runApplication<SimpleTaskApplication>(*args)
}
