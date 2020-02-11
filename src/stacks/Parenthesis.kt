package stacks

import java.util.*

class Parenthesis {

    // https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    fun maxDepth(s: String): Int {
        val stack = Stack<Char>()
        var count = 0
        var result = 0
        for (ch in s) {
            if (ch == '(') {
                stack.push(ch)
                count++
                result = Math.max(result, count)
            } else if (ch == ')') {
                count--
            }
        }
        return result
    }

    // https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    fun removeOuterParentheses(s: String): String {
        var str = ""
        var count = 0
        for (ch in s) {
            if (ch == '(' && count++ > 0) {
                str += ch
            }
            if (ch == ')' && count-- > 1) {
                str += ch
            }
        }
        return str
    }

    fun removeOuterParenthesisStackSolution(s: String): String {
        val stack = Stack<Char>()
        var result = ""
        for (ch in s) {
            if (ch == '(') {
                if (stack.isNotEmpty()) {
                    result += ch
                }
                stack.push(ch)
            } else if (ch == ')') {
                stack.pop()
                if (stack.isNotEmpty()) {
                    result += ch
                }
            }
        }
        return result
    }
}

fun main() {
    println(Parenthesis().maxDepth("(1+(2*3)+((8)/4))+1"))
    println(Parenthesis().maxDepth("1+(2*3)/(2-1)"))
    println(Parenthesis().maxDepth("1"))

    println(Parenthesis().removeOuterParentheses("(()())(())()"))
    println(Parenthesis().removeOuterParentheses("()"))
}