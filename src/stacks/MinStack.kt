package stacks

import java.util.*

//https://leetcode.com/problems/min-stack/

class MinStack {

    /** initialize your data structure here. */

    private var s: Stack<Int> = Stack()

    private var minStack: Stack<Int> = Stack()


    fun push(x: Int) {
        s.push(x)
        if (minStack.empty()) {
            minStack.push(x)
        } else if (minStack.peek() >= x) {
            minStack.push(x)
        }

    }

    fun pop() {

        if (s.empty()) return
        var x = s.peek()
        if (x == minStack.peek()) {
            minStack.pop()
        }
        s.pop()

    }

    fun top(): Int {
        return s.peek()

    }

    fun getMin(): Int {

        if (minStack.empty()) return Int.MAX_VALUE
        return minStack.peek()

    }

}

fun main() {

    var minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())   //--> Returns -3.
    minStack.pop()
    println(minStack.top())     // --> Returns 0.
    println(minStack.getMin())

}