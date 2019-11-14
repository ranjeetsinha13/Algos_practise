package stringsproblems

class StringsProblems {

    fun reverse(charArray: CharArray) {
        for (i in 0 until charArray.size / 2) {
            charArray[i] = charArray[charArray.size - i - 1].also {
                charArray[charArray.size - i - 1] = charArray[i]
            }
        }
        println(charArray.contentToString())
    }

    fun reverseVowels(s: String): String {

        var left = 0
        var vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var right = s.length - 1
        var ch = s.toCharArray()
        while (left < right) {

            if (ch[left] !in vowels) {
                left++
                continue
            }

            if (ch[right] !in vowels) {
                right--
                continue
            }
            ch[right] = s[left].also { ch[left] = ch[right] }
            left++
            right--
        }
        return String(ch)

    }

    fun maxNumberOfBalloons(text: String): Int {

        var arr = IntArray(5) { 0 }

        var chArr = charArrayOf('b', 'a', 'l', 'o', 'n')

        for (ch in text) {

            if (ch in chArr) {
                arr[chArr.indexOf(ch)]++
            }
        }

        return Math.min(Math.min(arr[3] / 2, arr[2] / 2), Math.min(Math.min(arr[0], arr[1]), arr[4]))

    }

    // https://leetcode.com/problems/find-common-characters/
    fun commonChars(A: Array<String>): List<String> {

        var charCount = IntArray(26) { 0 }


        var result = mutableListOf<String>()

        for (s in A) {
            for (ch in s) {
                charCount[ch - 'a']++
            }
        }


        for (i in charCount.indices) {

            if (charCount[i] >= A.size) {
                for (j in 1..charCount[i] / A.size) {
                    result.add((i + 'a'.toInt()).toChar().toString())
                }
            }

        }

        return result

    }
}

fun main() {
    StringsProblems().reverse(charArrayOf('h', 'e', 'l', 'l', 'o'))
    println(StringsProblems().reverseVowels("hello"))
    println(StringsProblems().maxNumberOfBalloons("balon"))
    println(StringsProblems().commonChars(arrayOf("bella", "label", "roller")))
}