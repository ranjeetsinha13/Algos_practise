package stacks

import java.lang.StringBuilder

class Paranthesis {

    // will not work as their are different types of brackets and the sequence of closing matters

    fun isValid(s: String): Boolean {

        var c1 = 0
        var c2 = 0
        var c3 = 0

        for (ch in s) {
            when (ch) {
                '{' -> c1++
                '(' -> c2++
                '[' -> c3++
                '}' -> c1--
                ')' -> c2--
                ']' -> c3--
            }

            if (c1 < 0 || c2 < 0 || c3 < 0) {
                return false
            }

        }

        return (c1 == 0 && c2 == 0 && c3 == 0)

    }

    fun removeUnbalancedParanthesis(s: String, open: Char, close: Char): StringBuilder {
        var count = 0
        var sb = StringBuilder()
        for (ch in s) {

            if (ch == open) {
                count++
            }

            if (ch == close) {
                if (count == 0) {
                    continue
                }
                count--
            }
            sb.append(ch)
        }

        return sb
    }

    fun minRemoveToMakeValid(s: String): String {

        var result = removeUnbalancedParanthesis(s, '(', ')')
        result = removeUnbalancedParanthesis(result.reverse().toString(), ')', '(')

        return result.reverse().toString()


    }


}

fun main() {
    println(Paranthesis().isValid("()[]{}"))

    println(Paranthesis().minRemoveToMakeValid("lee(t(c)o)de)"))

}