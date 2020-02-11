package stringsproblems

import java.util.*

class TopKFrequntElements {

    fun topKFrequentElements(words: Array<String>, k: Int): List<String> {
        val hashMap = mutableMapOf<String, Int>()
        for (word in words) {
            if (hashMap.containsKey(word)) {
                hashMap[word] = hashMap[word]!! + 1
            } else {
                hashMap[word] = 1
            }
        }
        var candidates = hashMap.keys.toMutableList()

        candidates.sortWith(Comparator { o1, o2 ->
            if (hashMap[o1] == hashMap[o2]) {
                o1.compareTo(o2)
            } else {
                hashMap[o2]!! - hashMap[o1]!!
            }
        })
        print(candidates)

        return candidates.subList(0, k)

    }
}

fun main() {
    TopKFrequntElements().topKFrequentElements(
        arrayOf(
            "i", "love", "leetcode", "i", "love", "coding"

        ), 4
    )

}