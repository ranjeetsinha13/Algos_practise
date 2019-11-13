class FirstUniqueChar {


    fun firstUniqChar(s: String): Int {

        var cc: HashMap<Char, CharCount> = HashMap()


        for (i in s.indices) {

            if (cc.containsKey(s[i])) {
                var count = cc[s[i]]?.count ?: 0

                cc[s[i]] = CharCount(cc[s[i]]?.index!!, count + 1)
            } else {
                cc[s[i]] = CharCount(i, 1)
            }

        }
        var minIndex = Int.MAX_VALUE
        for (key in cc.keys) {

            if (cc[key]?.count == 1 && cc[key]?.index!! < minIndex) {
                minIndex = cc[key]?.index ?: -1
            }

        }
        if (minIndex == Int.MAX_VALUE) minIndex = -1
        return minIndex

    }

    //https://leetcode.com/contest/leetcode-weekly-contest-2/problems/find-the-difference/
    fun findTheDifference(s: String, t: String): Char {

        var c = 0

        for (ch in s) {
            c = c.xor(ch.toInt())
        }
        for (ch in t) {
            c = c.xor(ch.toInt())
        }

        return c.toChar()

    }

    //https://leetcode.com/contest/leetcode-weekly-contest-2/problems/elimination-game/

    fun lastRemaining(n: Int): Int {

        var list: MutableList<Int> = mutableListOf()

        for (i in 1..n) {
            list.add(i)
        }
        var counter = 0
        while (list.size > 1) {

            if (counter % 2 == 0) {
                //list.removeAt()
            } else {

            }
        }

        return 0
    }

}


class CharCount(var index: Int, var count: Int)

fun main() {

    println(FirstUniqueChar().firstUniqChar(""))
    println(FirstUniqueChar().findTheDifference("abcd", "abced"))

}