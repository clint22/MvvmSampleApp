package com.bestdocapp.mvvmsampleapp

import org.junit.Assert.*
import org.junit.Test

class ExtensionFunctionsTest {

    @Test
    fun shouldHaveInput() {

        val input = "Kotlin"
        val result = validate(input)
        assertEquals(result, true)
    }

    @Test
    fun shouldNotBeNullInput() {

        val input = null
        val result = validate(input)
        assertEquals(result, false)

    }
}