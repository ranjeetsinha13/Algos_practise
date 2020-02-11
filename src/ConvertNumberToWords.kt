import java.lang.StringBuilder
import kotlin.math.abs

class ConvertNumberToWords {
    val units = arrayOf(
        "zero", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    )

    val tens = arrayOf(
        "",  // 0
        "",  // 1
        "Twenty",  // 2
        "Thirty",  // 3
        "Forty",  // 4
        "Fifty",  // 5
        "Sixty",  // 6
        "Seventy",  // 7
        "Eighty",  // 8
        "Ninety" // 9
    )

    fun convert(n: Int): String {
        if (n < 0) {
            return "Minus " + convert(-n)
        }
        if (n < 20) {
            return units[n]
        }
        if (n < 100) {
            return tens[n / 10] + (if (n % 10 != 0) " " else "") + units[n % 10]
        }
        if (n < 1000) {
            return units[n / 100] + " Hundred" + (if (n % 100 != 0) " " else "") + convert(n % 100)
        }
        if (n < 1000000) {
            return convert(n / 1000) + " Thousand" + (if (n % 100000 != 0) " " else "") + convert(n % 1000)
        }
        return if (n < 100000000) {
            convert(n / 1000000) + " Million" + (if (n % 1000000 != 0) " " else "") + convert(n % 1000000)
        } else convert(n / 1000000000) + " Billion" + (if (n % 1000000000 != 0) " " else "") + convert(n % 1000000000)
    }


    fun numberToWords(n: Int): String {

        val units = arrayOf(
            "zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"
        )
        var n = n


        var num = 0

        var str = ""


        var l = arrayListOf<Int>()
        while (n != 0) {
            num = (num * 10) + (n % 10)
            n /= 10
        }

        while (num > 0) {
            str += units[num % 10] + "-"
            num /= 10
        }

        return str

    }

    fun numberToWords2(n: Int, s: StringBuilder = StringBuilder()): String {

        val units = arrayOf(
            "zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"
        )
        var n = n
        if (n < 0) {
            s.append("minus")
            n = abs(n)
        }
        if (n < 10) {
            s.append(units[n])
        } else {
            (numberToWords2(n / 10, s.append(units[n % 10])))
        }

        return s.toString()

    }
}

fun main() {
    println(ConvertNumberToWords().convert(0))


    println(ConvertNumberToWords().numberToWords2(-234500))
}