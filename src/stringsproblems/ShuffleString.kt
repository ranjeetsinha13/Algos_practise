package stringsproblems


fun restoreString(s: String, indices: IntArray): String {

    // Corner case
    if (s.isNullOrEmpty()) return s
    var cArr = s.toCharArray()
    for (i in indices.indices) {
        // swap cArr[i] with cArr[indices[i]]
        while (i != indices[i]) {
            cArr[i] = cArr[indices[i]].also { cArr[indices[i]] = cArr[i] }
            indices[i] = indices[indices[i]].also { indices[indices[i]] = indices[i] }
        }
    }
    return cArr.joinToString("")
}

fun main() {
    // "codeleet", indices = [4,5,6,7,0,2,1,3]
    println(restoreString("codeleet", intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)))
}