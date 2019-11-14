import java.util.*
import kotlin.collections.ArrayList

class IntersectionofLists {

    fun intersection(arr1: Array<Int>, arr2: Array<Int>): IntArray {

        Arrays.sort(arr1)
        Arrays.sort(arr2)

        if (arr2.size > arr1.size) {
            return findIntersection(arr1, arr2)
        }
        return findIntersection(arr1, arr2)

    }

    fun findIntersection(arr1: Array<Int>, arr2: Array<Int>): IntArray {
        var intersectionofLists = IntArray(arr1.size) { 0 }


        val b = BinarySearch()
        var index = 0

        for (element in arr1) {
            if (b.binarySearchIterative(arr2, element) != -1) {
                intersectionofLists[index++] = element
            }
        }

        return intersectionofLists.copyOf(index)

    }

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

        nums1.sort()
        nums2.sort()

        var i1 = 0
        var i2 = 0
        var index = 0

        var arr = IntArray(nums1.size) { 0 }
        while (i1 < nums1.size && i2 < nums2.size) {

            var v1 = nums1[i1]
            var v2 = nums2[i2]
            if (v1 == v2) {
                arr[index++] = v1

                // for duplicates
                while (i1 < nums1.size && v1 == nums1[i1]) {
                    i1++
                }
                while (i2 < nums2.size && v2 == nums2[i2]) {
                    i2++
                }
            }

            if (v2 > v1) {
                while (i1 < nums1.size && v1 == nums1[i1]) {
                    i1++
                }
            } else {
                while (i2 < nums2.size && v2 == nums2[i2]) {
                    i2++
                }

            }
        }

        return arr.copyOf(index)

    }
}

fun main() {

    println(IntersectionofLists().intersection(arrayOf(1, 2, 2, 1), arrayOf(2, 2)))

}