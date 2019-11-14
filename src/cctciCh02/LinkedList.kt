package cctciCh02

import kotlin.concurrent.timerTask


class ListNode(var value: Int) {
    var next: ListNode? = null
}

class LinkedList {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    fun removeDuplicates(head: ListNode?): ListNode? {

        var temp = head

        while (temp?.next != null) {

            while (temp.value == temp?.next?.value) {
                temp.next = temp?.next?.next
            }
            temp = temp?.next

        }

        printList(head)
        return head

    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    fun removeDuplicates2(head: ListNode?): ListNode? {

        var temp = head

        var dummy: ListNode? = ListNode(0)
        dummy?.next = head
        var prev = dummy

        while (temp != null) {

            while (temp?.next != null && prev?.next?.value == temp?.next?.value) {
                temp = temp?.next
            }

            if (prev?.next == temp) {
                prev = prev?.next
            } else {
                prev?.next = temp?.next

            }

            temp = temp?.next

        }

        printList(dummy?.next)
        return dummy?.next
    }


    fun removeDuplicates3(head: ListNode?): ListNode? {

        var temp = head

        while (temp != null) {

            var ptr = temp

            while (ptr?.next != null) {

                if (temp.value == ptr?.next?.value) {
                    ptr?.next = ptr?.next?.next
                } else
                    ptr = ptr?.next
            }

            temp = temp.next

        }

        printList(head)

        return head

    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var posToDelete = getListSize(head) - n

        var temp = head

        if (posToDelete == 0) {
            temp = temp?.next
            return temp
        }

        var prev = temp

        var count = 0

        while (count != posToDelete) {

            prev = temp
            temp = temp?.next
            count++
        }

        prev?.next = temp?.next

        printList(head)

        return head


    }

    fun getListSize(head: ListNode?): Int {

        var temp = head
        var count = 0
        while (temp != null) {
            temp = temp?.next
            count++
        }
        return count
    }

    fun printList(head: ListNode?) {
        var temp = head
        while (temp != null) {
            print(temp?.value.toString() + " ->")
            temp = temp?.next
        }
    }

}

fun main() {

    var head = ListNode(1)
    head.next = ListNode(2)
    head?.next?.next = ListNode(3)
    head?.next?.next?.next = ListNode(3)
    head?.next?.next?.next?.next = ListNode(4)
    head?.next?.next?.next?.next?.next = ListNode(3)
    head?.next?.next?.next?.next?.next?.next = ListNode(5)

    //(LinkedList().removeDuplicates2(head))
    //LinkedList().removeNthFromEnd(ListNode(1), 1)
    LinkedList().removeDuplicates3(head)


}