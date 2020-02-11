package stacks

import java.lang.StringBuilder
import java.util.*

class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {

        val stack = Stack<Char>()
        var count = 0
        for (n in num) {
            while (stack.isNotEmpty() && count < k && stack.peek() > n) {
                stack.pop()
                count++
            }
            stack.push(n)
        }

        for (i in count until k) {
            if (!stack.isEmpty()) {
                stack.pop()
            }
        }

        var leadingZero = true
        val s = StringBuilder()
        for (e in stack) {
            if (leadingZero && e == '0') {
                continue
            }
            leadingZero = false
            s.append(e.toChar())
        }
        if (s.isEmpty()) return "0"
        return s.toString()

    }
}

fun main() {

    println(RemoveKDigits().removeKdigits("1234567890", 9))

}