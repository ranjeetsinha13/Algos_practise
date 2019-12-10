package arrayProblems

import java.util.*

class KthLargestElemnet {

    fun findKthLargest(nums: IntArray, k: Int): Int {

        var p = PriorityQueue<Int>(nums.size) { o1, o2 ->
            o1 - o2
        }

        for (n in nums) {
            p.add(n)
            if (p.size > k) {
                p.poll()
            }
        }

        return p.poll()


    }

}

fun main() {

}