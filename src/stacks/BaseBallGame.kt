package stacks

import java.lang.NumberFormatException
import java.util.*

class BaseBallGame {

    fun calPoints(ops: Array<String>): Int {
        val stack = Stack<Int>()
        for (o in ops) {
            try {
                stack.push(o.toInt())
            } catch (e: NumberFormatException) {
                if (o == "C") {
                    stack.pop()
                } else if (o == "D") {
                    stack.push(stack.peek() * 2)
                } else if (o == "+" && stack.size >= 2) {
                    val a = stack.pop()
                    val b = stack.pop()
                    stack.push(b)
                    stack.push(a)
                    stack.push(a + b)
                }
            }
        }
        var sum = 0
        for (e in stack) {
            sum += e
        }
        return sum
    }
}

fun main() {
    println(BaseBallGame().calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")))
}