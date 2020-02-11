package stacks

import java.lang.StringBuilder
import java.util.*

class Paranthesis {

    // will not work as their are different types of brackets and the sequence of closing matters

    fun isValid(s: String): Boolean {

        var str = mutableMapOf<Char, Char>()
        str.put('}', '{')
        str.put(')', '(')
        str.put(']', '[')

        var stack = Stack<Char>()

        for (ch in s) {
            if (str.containsKey(ch)) {
                val topElement: Char? = if (stack.isEmpty()) { '#' } else { stack.pop() }
                if (topElement != str[ch]) {
                    return false
                }
            } else {
                stack.push(ch)
            }
        }
        return stack.isEmpty()

    }

    fun validParenthesis(str: String): Boolean {
        if (str.isNullOrEmpty()) return false

        var counter = 0

        for (ch in str) {

            if (ch == ')') {
                counter++

                if (counter > 0) {
                    return false
                }
            } else counter--
        }
        return counter == 0
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