package stringsproblems


class ReverseWords {
    fun reverseWords(data: String): String {
        var result = mutableListOf<String>()
        var word = ""

        val data = data.trim()
        for (ch in data) {
            if (ch != ' ') {
                word += ch
            } else if (word.isNotEmpty() && ch == ' ') {
                result.add(word)
                word = ""
            }
        }
        result.add(word)
        for (i in 0 until result.size / 2) {
            result[i] = result[result.size - 1 - i].also { result[result.size - 1 - i] = result[i] }
        }
        return result.joinToString(" ")
    }

    fun reverseWords(s: CharArray) {

        var s = s

        for (i in 0 until s.size / 2) {
            s[i] = s[s.size - 1 - i].also { s[s.size - 1 - i] = s[i] }
        }

        var end = 0
        var start = 0
        while (start < s.size) {
            while (end < s.size && s[end] != ' ') {
                end++
            }

            var tempStart = start
            var tempEnd = end - 1
            while (tempStart < tempEnd) {
                var temp = s[tempStart]
                s[tempStart++] = s[tempEnd]
                s[tempEnd--] = temp
            }
            start = end + 1
            end++
        }

    }
}

fun main() {
    println(ReverseWords().reverseWords(charArrayOf('a', 'x', ' ', 'b', 'c', 'd', ' ', 'e', 'f').contentToString()))
    println(ReverseWords().reverseWords("   Leetcode    is    fun    also   "))
}