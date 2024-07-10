package com.giacom.simpletask.application.core.domain

import org.jetbrains.kotlin.daemon.common.trimQuotes
import org.junit.jupiter.api.Test

class ListTest {


    @Test
    fun `should create a list`() {
        val list = listOf("a", "b", "c")
        val string: String = list.joinToString()
        println(string)
        val list2 = listOf(string)
        println(list2)
    }

}
