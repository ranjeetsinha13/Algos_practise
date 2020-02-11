package arrayProblems

import binarySearch.BinarySearch
import java.util.*

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

    fun intersectionOf3Arrays(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {

        var i = 0
        var j = 0
        var k = 0
        var result = mutableListOf<Int>()
        while (i < nums1.size && j < nums2.size && k < nums3.size) {
            if (nums1[i] == nums2[j] && nums2[j] == nums3[k]) {
                result.add(nums1[i])
                i++
                j++
                k++
            } else if (nums1[i] < nums2[j]) {
                i++
            } else if (nums2[j] < nums3[k]) {
                j++
            } else {
                k++
            }
        }
        return result

    }

    fun findElemntsinMin2arrays(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val hashMap = mutableMapOf<Int, Int>()
        val list = mutableListOf<Int>()
        for (n in nums1) {
            hashMap[n] = 1
        }


        for (n in nums2) {
            if (hashMap.containsKey(n)) {
                hashMap[n] = hashMap[n]!! + 1
            } else {
                hashMap[n] = 1
            }
        }

        for (n in nums3) {
            if (hashMap.containsKey(n)) {
                hashMap[n] = hashMap[n]!! + 1
            } else {
                hashMap[n] = 1
            }
        }

        for (key in hashMap.keys) {
            if (hashMap[key]!! >= 2) {
                list.add(key)
            }
        }

        return list


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

    println(
        IntersectionofLists().findElemntsinMin2arrays(
            intArrayOf(1, 5, 10, 20, 40, 80), intArrayOf(5, 7, 20, 80, 120),
            intArrayOf(3, 4, 15, 20, 30, 70, 80, 120)
        )
    )

    println(
        IntersectionofLists().intersectionOf3Arrays(
            intArrayOf(1, 5, 10, 20, 40, 80), intArrayOf(6, 7, 20, 80, 100),
            intArrayOf(3, 4, 15, 20, 30, 70, 80, 120)
        )
    )
    println(IntersectionofLists().intersection(arrayOf(1, 2, 2, 1), arrayOf(2, 2)))

}