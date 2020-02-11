package arrayProblems

class MaxSumNoAdjacentElement {
    fun findMaxSum(arr: IntArray): Int {
        var incl = arr[0]
        var excl = 0
        var excl_new: Int
        var i = 1
        while (i < arr.size) {
            /* current max excluding i */excl_new = Math.max(incl, excl)
            /* current max including i */incl = excl + arr[i]
            excl = excl_new
            i++
        }
        /* return max of incl and excl */return Math.max(incl, excl)
    }
}


fun main() {
    println(MaxSumNoAdjacentElement().findMaxSum(intArrayOf(5, 5, 10, 100, 10, 5)))
}

