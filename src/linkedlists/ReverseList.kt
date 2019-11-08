package linkedlists


class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {

        var prev: ListNode? = null

        var current = head

        while (current != null) {

            var next: ListNode? = current.next
            current.next = prev
            prev = current
            current = next

        }

        return prev

    }

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {

        var prev: ListNode? = null

        var current = head

        for (i in 0 until m) {
            current = current?.next
        }

        var count = 0
        while (current != null && count < n) {

            var next: ListNode? = current.next
            current.next = prev
            prev = current
            current = next
            count++

        }

        return prev

    }
}

fun main() {
    var head = ListNode(1)
    head.next = ListNode(2)
    head.next = ListNode(3)
    head.next = ListNode(4)
    head.next = ListNode(5)
    head.next = null
    print(ReverseList().reverseBetween(head, 2, 4))
}