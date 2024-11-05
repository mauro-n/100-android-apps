package com.example.binconverter

fun binaryToDecimal(n: Long): Long {
    val num = n;
    var decimalValue = 0L;
    // Initializing base
    // value to 1, i.e 2^0
    var base = 1;
    var temp = num;
    while (temp > 0) {
        val lastDigit = temp % 10;
        temp = temp / 10;
        decimalValue += lastDigit * base;
        base *= 2;
    }

    return decimalValue;
}

fun parseInput(input: String, maxSize: Int): String {
    val lastIndex = if (input.length <= maxSize) input.length - 1 else maxSize - 1
    val initialVal = input.slice(0 .. lastIndex)
    var result = ""
    for (char in initialVal) {
        if (char != '0') {
            result += '1'
        } else {
            result += char
        }
    }
    return result
}