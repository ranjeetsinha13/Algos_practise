package arrayProblems

class AddOneToNumber {
    fun solution(arr: IntArray): IntArray {

        var result = IntArray(arr.size + 1) { 0 }

        var index = arr.size - 1

        var resultIndex = result.size - 1

        var carry = 1

        while (index >= 0) {

            var sum = arr[index] + carry
            result[resultIndex--] = sum % 10
            carry = sum / 10
            index--
        }

        if (carry == 1) {
            result[0] = carry
        } else {
            result = result.copyOfRange(1, result.size)
        }

        return result
    }
}


fun main() {

    println(AddOneToNumber().solution(intArrayOf(9)).contentToString())

}