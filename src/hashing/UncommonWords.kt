package hashing

class UncommonWords {

    fun uncommonFromSentences(A: String, B: String): Array<String> {

        val list1 = A.split(" ")
        val list2 = B.split(" ")

        val map = mutableMapOf<String, Int>()
        for (w in list1) {
            if (map.containsKey(w)) {
                map[w] = map[w]!! + 1
            } else {
                map[w] = 1
            }
        }
        for (w in list2) {
            if (map.containsKey(w)) {
                map[w] = map[w]!! + 1
            } else {
                map[w] = 1
            }
        }

        var result = mutableListOf<String>()

        for (w in map.keys) {
            if (map[w] == 1) {
                result.add(w)
            }
        }
        return result.toTypedArray()

    }

}

fun main() {
    println(UncommonWords().uncommonFromSentences("this apple is sweet", "this apple is sour").contentToString())
}