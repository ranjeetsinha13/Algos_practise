package stacks

class BuildArrayWithStackOperations {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()
        var count = 0
        for (i in target) {
            if (i != count + 1) {
                while (i != count + 1) {
                    result.add("Push")
                    result.add("Pop")
                    count++
                }
                result.add("Push")
                count++
            }
           else {
                result.add("Push")
                count++
            }
        }
        return result
    }
}
fun main() {

}