import java.util.*

class QuickSort {
    private fun partition(intArray: Array<Int>, low: Int, high: Int): Int {

        var pivot = intArray[high]
        var i = low - 1

        for (j in low until high) {

            if (intArray[j] <= pivot) {
                i++

                intArray[i] = intArray[j].also { intArray[j] = intArray[i] }
            }
        }
        intArray[i + 1] = intArray[high].also { intArray[high] = intArray[i + 1] }
        return i + 1

    }

    fun sort(intArray: Array<Int>, low: Int, high: Int) {

        if (low < high) {
            val p = partition(intArray, low, high)
            sort(intArray, low, p - 1)
            sort(intArray, p + 1, high)
        }
    }


}

fun main() {
    val intArray = arrayOf(2, 3, 8, 7, 11, 1, -1)
    val q = QuickSort()
    q.sort(intArray, 0, intArray.size - 1)
    print(Arrays.toString(intArray))
}