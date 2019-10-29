import java.lang.StringBuilder

class EncodeStringLength {

    fun encodeLength(str: String): String {

        var encodedStr = StringBuilder()

        var i = 0

        while (i < str.length) {
            var count = 1
            while (i < str.length - 1 && str[i] == str[i + 1]) {
                count++
                i++
            }
            encodedStr.append(str[i])
            encodedStr.append(count)
            i++
        }

        return encodedStr.toString()
    }
}

fun main() {

    println(EncodeStringLength().encodeLength("aabbbbcccccccddeeeeeeffghhhhhi"))

}