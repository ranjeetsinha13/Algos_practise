package ctciCh01

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 */
class URLlify {


    fun urlify(s: String): String {
        var charArr = s.toCharArray()

        var spacesCount = countSpaces(charArr)

        // initialise a new arr
        var newArray = CharArray(s.length + countSpaces(charArr) * 2) { ' ' }

        var pos = 0
        for (i in charArr.indices) {
            if (charArr[i] != ' ') {
                newArray[pos++] = charArr[i]
            } else {
                if (i < charArr.size - 2 && charArr[i] == ' ' && charArr[i + 1] != ' ') {
                    newArray[pos++] = '%'
                    newArray[pos++] = '2'
                    newArray[pos++] = '0'
                }
            }
        }

        return String(newArray)
    }

    private fun countSpaces(charArr: CharArray): Int {
        var count = 0
        for (i in 0 until charArr.size - 1) {
            if (charArr[i] == ' ' && charArr[i + 1] != ' ' ||
                (charArr[i + 1] == ' ' && i == charArr.size - 2)
            ) {
                count++
            }
        }
        return count

    }
}

fun main() {

    val u = URLlify()
    print(u.urlify("Mr  John Smith  "))


}