import java.lang.StringBuilder

class FormatNumberUsingHyphen {

    fun formatNumber(number: String): String {

        var a = StringBuilder()

        for (i in number.indices) {
            a.append(number[i])
            if ((i + 1) % 3 == 0 && i != number.length - 1) {
                a.append("-")
            }
        }
        return a.toString()
    }
}

fun main() {

    println(FormatNumberUsingHyphen().formatNumber("2342354524621412425364423521523"))

}