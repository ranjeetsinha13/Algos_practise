package linkedlists

class ListNode(var value: Int) {
    var next: ListNode? = null
}

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        var c1 = l1
        var c2 = l2

        var dummy = ListNode(0)

        var c3 = dummy

        while (c1 != null && c2 != null) {

            if (c1.value <= c2.value) {
                c3.next = c1
                c1 = c1.next
            } else {
                c3.next = c2
                c2 = c2.next
            }
            c3 = c3.next as ListNode

        }

        if (c1 != null) {
            c3.next = c1
        }

        if (c2 != null) {
            c3.next = c2
        }

        return dummy.next

    }

}

fun main() {

}