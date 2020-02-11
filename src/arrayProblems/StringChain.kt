package arrayProblems

class StringChain {

    fun stringChain(array: List<String>): List<String> {

        var result = mutableListOf<String>()

        for (str in array) {
            val word = getWordEndsWithFirstChar(str, array)
            if (word != null) {
                result.add(word)
            }
        }
        return result

    }

    private fun getWordEndsWithFirstChar(str: String, array: List<String>): String? {
        for (word in array) {
            if (word.endsWith(str[0])) {
                return word
            }
        }
        return null

    }

}


fun main() {

}