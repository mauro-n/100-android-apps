package com.example.binconverter

import org.junit.Assert
import org.junit.Test

class UtilsUnitTest {

    @Test
    fun parseInput_1() {
        val input = "12345678"
        val expected: String = "1111111"
        val result = parseInput(input, 7)
        Assert.assertEquals(result, expected)
    }

    @Test
    fun parseInput_2() {
        val input = "ab0de"
        val expected: String = "11011"
        val result = parseInput(input, 7)
        Assert.assertEquals(result, expected)
    }

    @Test
    fun convertToDecimal() {
        val input = 111L
        val expected = 7L
        val result = binaryToDecimal(input)
        Assert.assertEquals(result, expected)
    }

    @Test
    fun convertToDecimal_1() {
        val input = 0L
        val expected = 0L
        val result = binaryToDecimal(input)
        Assert.assertEquals(result, expected)
    }
}