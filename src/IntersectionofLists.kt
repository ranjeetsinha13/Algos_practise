import java.util.*
import kotlin.collections.ArrayList

class IntersectionofLists {

    fun intersection(arr1: Array<Int>, arr2: Array<Int>): ArrayList<Int> {

        Arrays.sort(arr1)
        Arrays.sort(arr2)

        if (arr2.size > arr1.size) {
            return findIntersection(arr1, arr2)
        }
        return findIntersection(arr1, arr2)

    }

    fun findIntersection(arr1: Array<Int>, arr2: Array<Int>): ArrayList<Int> {
        var intersectionofLists = ArrayList<Int>()


        val b = BinarySearch()

        for (element in arr1) {
            if (b.binarySearchIterative(arr2, element) != -1) {
                intersectionofLists.add(element)
            }
        }

        return intersectionofLists

    }
}

fun main() {

    println(IntersectionofLists().intersection(arrayOf(2, 3, 4, 5), arrayOf(5, 6, 7, 8, 2)))

}