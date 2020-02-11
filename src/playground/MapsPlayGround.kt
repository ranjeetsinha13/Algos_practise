package playground

import java.lang.ref.WeakReference
import java.math.BigInteger
import java.security.MessageDigest
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

    fun md5test(testString: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(testString.toLowerCase().trim().toByteArray())).toString(16).padStart(32, '0')
    }

    fun concurrentModificationTest() {
        val li = mutableListOf(PhaseTimestamp("a", "b"), PhaseTimestamp("c", "d"))
        val res = li.find { it.name == "c" }.also { li.remove(it) }
        println((res as PhaseTimestamp).name)
        println(li[0].name)
    }
}

internal class PhaseTimestamp(
        val name: String,
        val timestamp: String
)


data class Sample(val a: Int, val b: Int)

fun main() {
    MapsPlayGround().concurrentModificationTest()
    println(MapsPlayGround().md5test("4744wmListest141263@listsvcaut.com") == "80aa0e7ae4e9b1796d4b20c026980795")
    println(MapsPlayGround().md5test("reidshocking@expressgopher.com ") == "080dba889ddd970d2301a7fbabfc033f")
    println(MapsPlayGround().md5test("ccarella@GMAIL.com") == "e5bfdaa63d454be6cacac62df1e0ffaa")
    println(MapsPlayGround().md5test("pooleaw@yahoo.com") == "456716bc2f690bb372e4022dd9de963c")
    println(MapsPlayGround().md5test("wmtest1619748931661@aut.com") == "aa0b44f7df25d657c7c6e4f3fe703355")
}