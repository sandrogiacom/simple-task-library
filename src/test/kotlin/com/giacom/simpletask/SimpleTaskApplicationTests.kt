package com.giacom.simpletask

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.PropertySource

@SpringBootTest(
    classes = [SimpleTaskApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

class SimpleTaskApplicationTests {

    @Test
    fun contextLoads() {
    }

}
