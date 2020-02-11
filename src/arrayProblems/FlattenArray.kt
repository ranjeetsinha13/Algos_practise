import java.util.*

interface NestedInteger {
    fun isInteger(): Boolean

    fun getInteger(): Int

    fun getList(): List<NestedInteger>
}

class NestedIterator(nestedList: List<NestedInteger>) :
    Iterator<Integer> {
    private val list: LinkedList<Int> = LinkedList()
    private fun initialize(nestedList: List<NestedInteger>) {
        for (num in nestedList) {
            if (num.isInteger()) list.add(num.getInteger()!!) else initialize(num.getList())
        }
    }

    override fun next(): Integer {
        return  Integer(list.poll())
    }

    override fun hasNext(): Boolean {
        return !list.isEmpty()
    }

    init {
        initialize(nestedList)
    }
}