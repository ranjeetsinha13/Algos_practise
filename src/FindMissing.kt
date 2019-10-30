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
}

fun main() {

    val a = intArrayOf(0, 10, 2, -10, -20)
    println(FindMissing().findMissing(a))
}

