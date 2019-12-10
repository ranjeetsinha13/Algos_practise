

class LRUCacheImpl {

    val LRU_SIZE = 4
    var hashmap: HashMap<Int, Entry>? = null
    var start: Entry? = null
    var end: Entry? = null

    init {
        hashmap = HashMap()
    }

    fun getEntry(key: Int): Int? {

        if (hashmap?.containsKey(key) == true) {
            val entry: Entry? = hashmap?.get(key)
            removeNode(entry)
            addToTop(entry)
            return entry?.value

        }

        return -1

    }

    fun putEntry(key: Int, value: Int) {

        if (hashmap?.containsKey(key) == true) {
            val entry: Entry? = hashmap?.get(key)
            removeNode(entry)
            addToTop(entry)

        } else {
            val entry = Entry(null, null, key, value)

            if (hashmap?.size!! > LRU_SIZE) {

                hashmap?.remove(end?.key)
                removeNode(end)
                addToTop(entry)

            } else {
                addToTop(entry)
            }
            hashmap?.put(key, entry)
        }

    }

    fun removeNode(node: Entry?) {
        var nodeTemp = node

        if (nodeTemp?.prev != null) {
            nodeTemp?.prev?.next = nodeTemp?.next
        } else {
            start = nodeTemp?.next
        }

        if (nodeTemp?.next != null) {
            nodeTemp?.next?.prev = nodeTemp?.prev
        } else {
            end = nodeTemp?.prev
        }


    }

    fun addToTop(node: Entry?) {

        var nodeTemp = node

        nodeTemp?.next = start
        nodeTemp?.prev = null

        if (start != null) {
            start?.prev = nodeTemp
        }

        start = node

        if (end == null) {
            end = start
        }

    }


}

class Entry(var prev: Entry?, var next: Entry?, val key: Int, val value: Int)


fun main() {

    val lrucache: LRUCacheImpl = LRUCacheImpl()
    lrucache.putEntry(1, 1)
    lrucache.putEntry(10, 15)
    lrucache.putEntry(15, 10)
    lrucache.putEntry(10, 16)
    lrucache.putEntry(12, 15)
    lrucache.putEntry(18, 10)
    lrucache.putEntry(13, 16)

    System.out.println(lrucache.getEntry(1));
    System.out.println(lrucache.getEntry(10));
    System.out.println(lrucache.getEntry(15));

}