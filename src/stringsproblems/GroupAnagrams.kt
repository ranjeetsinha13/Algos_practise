package stringsproblems

import java.util.*
import java.util.concurrent.CopyOnWriteArrayList


class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        if (strs.isEmpty()) return arrayListOf()
        val ans: MutableMap<String, MutableList<String>> = HashMap()
        for (s in strs) {
            val ca = s.toCharArray().apply { sort() }
            val key = String(ca).trim()

            if (!ans.containsKey(key)) ans[key] = ArrayList()
            ans[key]?.add(s)
        }
        return ArrayList(ans.values)

    }

    fun abc() {
        var list = mutableListOf(1,2,3,4,5)
       val iter = list.iterator()
        while (iter.hasNext()) {
            val a = iter.next()
            if(a == 2) {
               iter.remove()
            }
        }
    }
}



fun main() {
    GroupAnagrams().abc()
    println(
        GroupAnagrams().groupAnagrams(
            arrayOf(
                "pear",
                "amleth",
                "dormitory",
                "tinsel",
                "dirty room",
                "hamlet",
                "listen",
                "silnet"
            )
        )
    )
}