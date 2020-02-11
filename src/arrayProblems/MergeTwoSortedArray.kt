package arrayProblems

class MergeTwoSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        var i = m - 1
        var j = n - 1

        var pointer = m + n - 1

        while ( i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[pointer] = nums1[i--]
            } else {
                nums1[pointer] = nums2[j--]
            }
            pointer--

        }

        while (i >= 0) {
            nums1[pointer--] = nums1[i--]
        }

        while (j >= 0) {
            nums1[pointer--] = nums2[j--]
        }


        println(nums1.contentToString())

    }
}

fun main() {
    MergeTwoSortedArray().merge(
        intArrayOf(10, 12, 13, 14, 18, 0, 0, 0, 0, 0), 5,
        intArrayOf(16, 17, 19, 20, 22), 5
    )
}