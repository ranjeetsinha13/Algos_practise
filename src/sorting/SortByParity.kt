package sorting

fun sortArrayByParityII(A: IntArray): IntArray {

    var evenPtr = 0
    var oddPtr = 1
    while (evenPtr < A.size && oddPtr < A.size) {
        if (A[evenPtr] % 2 == 0) {
            evenPtr += 2
        }
        else {
            A[oddPtr] = A[evenPtr].also { A[evenPtr] = A[oddPtr] }
        }
        if (A[oddPtr] % 2 != 0) {
            oddPtr += 2
        }
        else {
            A[oddPtr] = A[evenPtr].also { A[evenPtr] = A[oddPtr] }
        }
    }
    return A
}

fun main() {
    println(sortArrayByParityII(intArrayOf(4,2,5,7)).contentToString())
}