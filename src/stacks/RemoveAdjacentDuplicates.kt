package stacks

import java.util.*

class RemoveAdjacentDuplicates {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        for (ch in s) {
            if (stack.isNotEmpty()) {
                if (ch == stack.peek()) {
                    stack.pop()
                } else {
                    stack.push(ch)
                }
            } else {
                stack.push(ch)
            }
        }
        var result = ""
        for (element in stack.elements()) {
            result += element
        }
        return result
    }
}

fun main() {
    println(RemoveAdjacentDuplicates().removeDuplicates("abbaca"))
    println(RemoveAdjacentDuplicates().removeDuplicates("azxxzy"))
}