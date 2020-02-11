package arrayProblems

fun canThreePartsEqualSumWrong(A: IntArray): Boolean {

    // Does not work, this logic does not works  for partition array to 2 subarrays as well.
    // Sample input to test [18, -18, -18, 18, -19, -1, 10, 10]
    // This might work for +ve integers I think
    if (A.isEmpty() || A.size < 3) return false
    var left = 0
    var right = A.size - 1
    var sumLeft = A[0]
    var sumRight = A[right]
    var sumMiddle = 0
    while (left < right) {
        if (sumLeft == sumRight) {
            for (i in left + 1 until right) {
                sumMiddle += A[i]
            }
            if (sumLeft == sumMiddle) {
                return true
            } else {
                left++
                sumLeft += A[left]
                right--
                sumRight += A[right]
            }
        }
        if (sumLeft < sumRight) {
            left++
            sumLeft += A[left]
        } else {
            right--
            sumRight += A[right]
        }
    }
    return false
}

fun canThreePartsEqualSum(A: IntArray): Boolean {
    // check for corner case
    if (A.isEmpty() || A.size < 3) return false
    //calculate sum of all elements in A
    var sum = calculateSumArray(A)
    if (sum % 3 != 0) return false
    var sumToFind = sum / 3
    var firstPartition = 0
    var secondPartition = 0

    var index = 0

    for (i in A.indices) {
        firstPartition += A[i]
        if (firstPartition == sumToFind) {
            index = i + 1
            break
        }
    }
    for (i in index until A.size) {
        secondPartition += A[i]
        if (secondPartition == sumToFind) {
            index = i
            break
        }
    }
    return secondPartition == sumToFind && index != A.size - 1
}

private fun calculateSumArray(A: IntArray): Int {
    var sum = 0
    for (a in A) {
        sum += a
    }
    return sum
}

fun main() {
    //println(canThreePartsEqualSum(intArrayOf(0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1)))
    println(canThreePartsEqualSum(intArrayOf(18, 12, -18, 18, -19, -1, 10, 10)))
}