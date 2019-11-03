import java.lang.Math.abs
import java.util.Arrays


//Find the smallest positive number missing from an unsorted array

class FindMissing {

    fun findMissing(a: IntArray): Int {
        val m = Arrays.stream(a).max().asInt
        if (m < 1) {
            return 1
        }
        if (a.size == 1) {
            return if (a[0] == 1) {
                return 2
            } else 1
        }
        var l = IntArray(m)
        for (i in a.indices) {
            if (a[i] > 0) {
                if (l[a[i] - 1] != 1) {
                    l[a[i] - 1] = 1
                }
            }
        }
        for (i in l.indices) {
            if (l[i] == 0) {
                return i + 1
            }
        }
        return m + 1
    }

    fun findMissing2(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 1
        }
        Arrays.sort(nums)

        var j = 1

        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i]
            }
        }
        var start = 0
        for (i in 0 until j) {
            if (nums[i] > 0) {
                start = i
                break
            }
        }

        var count = 1
        for (i in start until j) {
            if (nums[i] != count) {
                return count
            }

            count++
        }
        count = j - start + 1
        return count
    }


}

fun main() {

    val a = intArrayOf(0, 10, 2, -10, -20)
    println(FindMissing().findMissing(a))
    println(FindMissing().findMissing2(intArrayOf(1)))
}

