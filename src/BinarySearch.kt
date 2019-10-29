class BinarySearch {

    fun binarySearchIterative(array: Array<Int>, number: Int): Int {

        var low = 0
        var high = array.size - 1

        while (low <= high) {

            var mid = (low + high) / 2

            when {
                number > array[mid] -> low = mid + 1
                number < array[mid] -> high = mid - 1
                number == array[mid] -> return mid
            }
        }
        return -1
    }

    fun binarySearchRecursive(array: Array<Int>, number: Int, low: Int, high: Int): Int {


        while (low <= high) {

            var mid = (low + high) / 2

            when {
                number > array[mid] -> return binarySearchRecursive(array, number, mid + 1, high)
                number < array[mid] -> return binarySearchRecursive(array, number, low, mid - 1)
                number == array[mid] -> return mid
            }
        }
        return -1
    }
}

fun main() {

    println(BinarySearch().binarySearchIterative(arrayOf(2, 3, 4, 5, 6, 7, 8), 2))
    println(BinarySearch().binarySearchRecursive(arrayOf(2, 3, 4, 5, 6, 7, 8), 3, 0, 7))


}