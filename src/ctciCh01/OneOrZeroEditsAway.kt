package ctciCh01

class OneOrZeroEditsAway {

    fun solution(s1: String, s2: String): Boolean {


        if (Math.abs(s1.length - s2.length) > 1) return false

        if (s1.length > s2.length) {

            // s2 is one addition away from s1
            return checkDistance(s2, s1)

        } else if (s2.length > s1.length) {
            //s1 is one addition away from s2
            return checkDistance(s1, s2)
        } else if (s1.length == s2.length) {
            return checkDistance(s1, s2)
        }
        return false

    }

    fun checkDistance(s1: String, s2: String): Boolean {

        var p1 = 0
        var p2 = 0
        var count = 0

        while (p1 < s1.length && p2 < s2.length) {
            if (s1[p1] != s2[p2]) {
                count++
                if (s1.length == s2.length) {
                    p1++
                    p2++
                } else {
                    p1++
                }

                if (count > 1) return false

            } else {
                p1++
                p2++
            }
        }
        return true

    }


    //https://leetcode.com/problems/rotate-string/

    fun isRotated(s1: String, s2: String): Boolean {

        var s = s1 + s1
        return s1.length == s2.length && s2 in s

    }
}

fun main() {
    println(OneOrZeroEditsAway().solution("geeks", "seek"))
    println(OneOrZeroEditsAway().isRotated("abcde", "cdeab"))
}