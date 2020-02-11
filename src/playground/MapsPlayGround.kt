package playground

import java.lang.ref.WeakReference
import java.util.*

class MapsPlayGround {
    fun pg() {
        val treeMap = TreeMap<String, String>()

        treeMap["b"] = "r"
        treeMap["a"] = "s"
        //mutableListOf<String>().indexOf()
        val s = mutableSetOf<String>()
        s.remove("23")
        //arrayListOf<String>().indexOf()

        val iterator = treeMap.keys.iterator()
        /*while (iterator.hasNext()) {
            val s = iterator.next()
            println(s)
            iterator.remove()

        }*/

        println(treeMap)
        }

}


data class Sample(val a: Int, val b: Int)

fun main() {
    MapsPlayGround().pg()
}