package arrayProblems

import java.math.BigInteger

class Test {

    fun barcodeToTc(barcode: String): String {
        val code39 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/%+"
        val bcChars: CharArray = barcode.toCharArray()
        if (bcChars.isNotEmpty()) {
            bcChars[0] = (bcChars[0] - 17)
            var base = BigInteger.ONE
            var num = BigInteger.ZERO
            val fortyThree = BigInteger.valueOf(43)
            for (i in bcChars.indices.reversed()) {
                val digit: Int = code39.indexOf(bcChars[i])
                if (digit == -1) {
                    return ""
                }
                num = num.add(base.multiply(BigInteger.valueOf(digit.toLong())))
                base = base.multiply(fortyThree)
            }
            val lenPlusTc = num.toString()
            if (lenPlusTc.length > 2) {
                val len = lenPlusTc.substring(0, 2).toInt()
                println("ccccc $len")
                if (len >= 0 && len <= lenPlusTc.length - 2) {
                    return lenPlusTc.substring(lenPlusTc.length - len)
                }
            }
        }

        return ""
    }
}

fun main() {
    println(Test().barcodeToTc("ABC"))
}