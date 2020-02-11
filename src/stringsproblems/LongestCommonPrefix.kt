package stringsproblems

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        if(strs == null || strs.isEmpty()) return ""

        var minLength = Integer.MAX_VALUE

        // Find the minimum length of the string
        for (str in strs) {
            if (minLength >= str.length) {
                minLength = str.length
            }
        }
        var high = minLength
        var low = 1
        while (low <= high) {
            var mid = (low + high) / 2
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return strs[0].substring(0, (low + high) / 2)
    }

}

fun isCommonPrefix(strs: Array<String>, mid: Int): Boolean {
    val string = strs[0].substring(0, mid)
    for (str in strs) {
        if (!str.startsWith(string)) {
            return false
        }
    }
    return true
}


fun main() {

}