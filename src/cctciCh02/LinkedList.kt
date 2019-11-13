package cctciCh02


class ListNode(var value: Int) {
    var next: ListNode? = null
}

class LinkedList {

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
    head.next = ListNode(1)
    head?.next?.next = ListNode(1)
    head?.next?.next?.next = ListNode(3)
    head?.next?.next?.next?.next = ListNode(3)

    (LinkedList().removeDuplicates(head))


}