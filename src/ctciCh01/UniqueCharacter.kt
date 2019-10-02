package ctciCh01

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
 */

class UniqueCharacter {

    // Complexity N^2
    fun isUnique(s: String): Boolean {
        for (i in s.indices) {
            for (j in i + 1 until s.length) {
                if (s[i] == s[j]) {
                    return false
                }

            }
        }
        return true
    }

    fun isUnique2(s: String): Boolean {

        val array = Array(127) { false }
        
        for (i in s.indices) {
            if (array[s[i].toInt()]) {
                return false
            }
            array[s[i].toInt()] = true
        }
        return true
    }
}

fun main() {

    val u = UniqueCharacter()

    print(u.isUnique("abcdefghijklmnopqsrtuvwxyz"))
    print(u.isUnique2("abcdefghijklmnopqsrtuvwxyzz"))

}