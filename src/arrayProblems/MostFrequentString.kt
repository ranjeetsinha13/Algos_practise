package arrayProblems

class MostFrequentString {

    fun mostFrequentString(list: List<String>): String {
        val hashMap = mutableMapOf<String, Int>()
        for (s in list) {
            if (hashMap.containsKey(s)) {
                hashMap[s] = hashMap[s]!! + 1
            } else {
                hashMap[s] = 1
            }
        }
        var maxCount = -1
        var result = ""
        for (key in hashMap.keys) {
            if (hashMap[key]!! > maxCount) {
                maxCount = hashMap[key]!!
                result = key

            }
        }
        return result
    }

    fun roundPrice(price: Int, n: Int): Long {
        var r = (Math.pow(10.0, (n).toDouble())).toLong()
        var num = price % r
        var q = price / r // q = 2

        var roundOffNum = 0L



        if (num < 0) {

            if (num < 5 * r / 10) {
                roundOffNum = q * r
            } else {
                roundOffNum = (q - 1) * r
            }
        } else if (num > 0) {
            if (num < 5 * r / 10) {
                roundOffNum = (q * r)
            } else {
                roundOffNum = (q + 1) * r
            }

        } else {
            roundOffNum = price.toLong()
        }
        if (roundOffNum == 0L) {
            roundOffNum = r
        }
        if (price == 0) {
            roundOffNum = price.toLong()
        }
        return roundOffNum


    }

    fun parseEmoticons(text: String): List<InlinedEmoticon> {
        //TODO Implement
        var emoticonList = mutableListOf<InlinedEmoticon>()
        for (i in text.indices) {
            if (text[i] == ':') {
                if (i + 1 < text.length) {

                }
                when {
                    text[i + 1] == ')' -> emoticonList.add(InlinedEmoticon(1, i, 2))
                    text[i + 1] == '/' -> emoticonList.add(InlinedEmoticon(2, i, 2))
                    text[i + 1] == '(' -> emoticonList.add(InlinedEmoticon(3, i, 2))
                    text[i + 1] == '-' -> {
                        if (i + 2 < text.length) {
                            when {
                                text[i + 2] == ')' -> emoticonList.add(InlinedEmoticon(1, i, 3))
                                text[i + 2] == '(' -> emoticonList.add(InlinedEmoticon(3, i, 3))
                            }
                        }

                    }

                }


            }
        }

        return emoticonList
    }

}

data class InlinedEmoticon(val emoticonId: Int, val position: Int, val length: Int)

fun main() {
    println(MostFrequentString().mostFrequentString(mutableListOf("a", "b", "c", "a", "b", "d", "a")))
    println(MostFrequentString().roundPrice(4, 1))
}