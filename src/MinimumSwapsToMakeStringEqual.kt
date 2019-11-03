import java.lang.StringBuilder

class MinimumSwapsToMakeStringEqual {
    fun minimumSwap(s1: String, s2: String): Int {

        if (s1.length != s2.length) {
            return -1
        }

        var arr = IntArray(256) { 0 }

        for (i in s1.indices) {
            arr[s1[i].toInt()]++
            arr[s2[i].toInt()]--
        }

        for (i in 0..255) {
            if (arr[i] != 0) {
                return -1
            }
        }

        var i = s1.length - 1
        var j = s2.length - 1
        var count = 0

        while (i >= 0) {
            if (s1[i] != s2[j]) {
                count++
            } else {
                j--
            }
            i--
        }
        return count

    }



    fun minimumSwap2(s1: String, s2: String): Int {
        return 0
    }


}

fun main() {
    println(MinimumSwapsToMakeStringEqual().minimumSwap("xy", "yx"))
}