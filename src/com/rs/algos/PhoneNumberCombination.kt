package com.rs.algos

class PhoneNumberCombination {

    private val keyMap = initialiseKeyMap()
    fun phoneNumberCombination(digits: String): List<String> {
        var result = mutableListOf<String>()
        // Corner case
        if (digits.isNullOrEmpty()) return emptyList()
        letterCombination(digits, 0, "", result)
        return result

    }

    private fun initialiseKeyMap(): Map<Int, List<Char>> {
        val map = mutableMapOf<Int, List<Char>>()
        map[1] = listOf('a', 'b', 'c')
        map[2] = listOf('d', 'e', 'f')
        map[3] = listOf('g', 'h', 'i')
        map[4] = listOf('j', 'k', 'l')
        map[5] = listOf('m', 'n', 'o')
        map[6] = listOf('p', 'q', 'r', 's')
        map[7] = listOf('t', 'u', 'v')
        map[8] = listOf('w', 'x', 'y', 'z')

        return map

    }

    private fun letterCombination(digits: String, index: Int, answer: String, result: MutableList<String>) {
        //
        if (index == digits.length) {
            result.add(answer)
            return
        }
        val charArray = keyMap?.get(digits[index].code - 48)!!
        for (c in charArray) {
            letterCombination(digits, index + 1, answer + c, result)
        }
    }
}

fun main() {
    println(PhoneNumberCombination().phoneNumberCombination("23"))
}