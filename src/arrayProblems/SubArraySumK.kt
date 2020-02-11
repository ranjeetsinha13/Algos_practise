package arrayProblems



// Works for +ve numbers
fun subArraySumK(nums: IntArray, k: Int): Int {

    var sum = 0

    var counter = 0

    var i = 0
    var j = 0
    while (i < nums.size && j < nums.size) {
        sum += nums[i]
        i++
        while (sum > k && j < i - 1) {
            sum -= nums[j]
            j++
        }
        if (sum == k) {
            println("$j,${i - 1}")
            counter++
        }
    }
    return counter

}

fun subArraySum(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map = mutableMapOf<Int,Int>()
    map[0] = 1
    for (i in nums.indices) {
        sum += nums[i]
        if (map.containsKey(sum - k)) count += map[sum - k]!!
        map[sum] = map.getOrDefault(sum, 0)!! + 1
    }
    return count
}

fun main() {
    //subArraySumK(intArrayOf(1, 4, 20, 3, 10, 5), 33)
    //subArraySumK(intArrayOf(1, 4, 0, 0, 3, 10, 5), 7)
    subArraySumK(intArrayOf(1, 1, 1), 2)
}