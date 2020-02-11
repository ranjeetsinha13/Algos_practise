package stringsproblems

import java.lang.StringBuilder

class Zalando {
    fun strWithout3a3b(A: Int, B: Int): String {

        var A = A
        var B = B

        val ans = StringBuilder()

        while (A > 0 || B > 0) {
            var writeA = false
            val L = ans.length
            if (L >= 2 && ans[L - 1] == ans[L - 2]) {
                if (ans[L - 1] == 'b')
                    writeA = true
            } else {
                if (A >= B)
                    writeA = true
            }

            if (writeA) {
                A--
                ans.append('a')
            } else {
                B--
                ans.append('b')
            }
        }

        return ans.toString()
    }


    // recusrion

    fun strwithouta3b3F(A: Int, B: Int, sb: StringBuilder = StringBuilder()): String {

        var A = A
        var B = B

        if (A == 0 || B == 0) {
            while (A-- > 0) sb.append('a')
            while (B-- > 0) sb.append('b')
        } else if (A == B) {
            sb.append("ab");
            strwithouta3b3F(A - 1, B - 1, sb)
        } else if (A > B) {   // A > B > 0
            sb.append("aab")
            strwithouta3b3F(A - 2, B - 1, sb)
        } else {              // B > A > 0
            sb.append("bba")
            strwithouta3b3F(A - 1, B - 2, sb)
        }
        return sb.toString()

    }

    fun strwithouta3b3F2(A: Int, B: Int): String {

        var A = A
        var B = B
        var sb = StringBuilder()

        if (A == 0 || B == 0) {
            while (A-- > 0) sb.append('a')
            while (B-- > 0) sb.append('b')
        } else if (A == B) {
            while (A == B) {
                sb.append("ab")
                A--
                B--
            }
        } else if (A > B) {   // A > B > 0
            while (B in 1 until A) {
                sb.append("aab")
                A -= 2
                B -= 1
            }
        } else {              // B > A > 0
            while (A in 1 until B) {
                sb.append("bba")
                B -= 2
                A -= 1
            }

        }
        return sb.toString()

    }
}

fun main() {

    println(Zalando().strWithout3a3b(9, 2))
    println(Zalando().strwithouta3b3F(4, 1))
    println(Zalando().strwithouta3b3F2(4, 1))

}