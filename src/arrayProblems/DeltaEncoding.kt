package arrayProblems

class DeltaEncoding {
    fun deltaEncoding(input: IntArray): String {

        var result = StringBuilder()
        if (input.isEmpty()) return ""
        result.append(input[0]).append(" ")
        for (i in 1 until input.size) {
            var diff = input[i] - input[i - 1]
            if (diff < -127 || diff > 127) {
                result.append("-128 ")
            }
            result.append(diff).append(" ")
        }
        return result.toString().trimEnd()

    }
}

fun main() {
    println(DeltaEncoding().deltaEncoding(intArrayOf(25626, 25757, 24367, 24267, 16, 100, 2, 7277)))
}