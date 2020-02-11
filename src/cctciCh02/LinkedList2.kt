package cctciCh02

class LinkedList2 {

    // 1,4,3,2,5,2; 3
    fun partition(head: ListNode?, x: Int): ListNode? {

        var firstListHead = ListNode(0)
        var secondListHead = ListNode(0)
        var firstList: ListNode? = firstListHead
        var secondList: ListNode? = secondListHead
        var temp = head

        while (temp != null) {
            if (temp.value < x) {
                firstList?.next = temp
                firstList = firstList?.next
            } else {
                secondList?.next = temp
                secondList = secondList?.next
            }

            temp = temp.next
        }

        secondList?.next = null
        firstList?.next = secondListHead?.next

        return firstListHead?.next

    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var sumHead: ListNode? = ListNode(0)

        var dummy = sumHead

        var t1 = l1

        var t2 = l2

        var carry = 0

        while (t1 != null || t2 != null) {

            var sum = (if (t1 != null) t1?.value else 0)
                    (if (t2 != null) t2?.value else 0)

            var result = sum!! + carry

            carry = result / 10

            dummy?.next = ListNode(result % 10)


            if (t1 != null) t1 = t1.next
            if (t2 != null) t2 = t2.next

            dummy = dummy?.next
        }


        if (carry > 0) {
            dummy?.next = ListNode(carry)
        }

        LinkedList().printList(sumHead?.next)


        return sumHead?.next

    }


}

fun main() {

    var l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    var l2 = ListNode(5)
    l2.next = ListNode(6)
    l2?.next?.next = ListNode(4)

    LinkedList2().addTwoNumbers(l1, l2)


}