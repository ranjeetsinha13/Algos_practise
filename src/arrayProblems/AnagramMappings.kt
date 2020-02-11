package arrayProblems

// https://leetcode.com/problems/find-anagram-mappings/
class AnagramMappings {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {

        val hashMap = mutableMapOf<Int, Int>()
        for (i in B.indices) {
            hashMap[B[i]] = i
        }

        var result = IntArray(A.size)
        var k = 0
        for (i in A.indices) {
            result[k++] = hashMap[A[i]]!!
        }

        return result

    }
}

fun main() {
    println(
        AnagramMappings().anagramMappings(
            intArrayOf(12, 28, 46, 32, 50),
            intArrayOf(50, 12, 32, 46, 28)
        ).contentToString()
    )
}