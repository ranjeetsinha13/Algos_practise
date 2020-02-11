import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class MeetingRoom {

    //https://leetcode.com/problems/meeting-rooms/submissions/

    fun minMeetingRoom(m: Array<Meeting>): Boolean {


        Arrays.sort(m) { o1, o2 -> o1.startTime - o2.startTime }

        for (i in 0 until m.size - 1) {
            if (m[i].endTime > m[i + 1].startTime) {
                return false
            }
        }
        return true

    }

    fun minMeetingRoom(m: Array<IntArray>): Boolean {


        Arrays.sort(m) { o1, o2 -> o1[0] - o2[0] }

        for (i in 0 until m.size - 1) {
            if (m[i][1] > m[i + 1][0]) {
                return false
            }
        }
        return true

    }

    fun minMeetingRooms(intervals: Array<IntArray>): Int {

        Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }

        var p: PriorityQueue<Int> = PriorityQueue(intervals.size) { o1, o2 ->
            o1 - o2
        }

        p.add(intervals[0][1])

        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= p.peek()) {
                p.poll()
            }
            p.add(intervals[i][1])
        }

        return p.size


    }

    fun busiestDay(arrival: IntArray, exit: IntArray): Int {
        val tm = mutableMapOf<Int, Int>()

        var max = Int.MIN_VALUE
        var result = -1

        for (i in arrival.indices) {
            for (j in arrival[i]..exit[i]) {
                if (tm.containsKey(j)) {
                    tm[j] = tm[j]!! + 1
                    if (tm[j]!! > max) {
                        result = j
                        max = tm[j]!!
                    }

                } else {
                    tm[j] = 1
                }
            }
        }
        println(tm)
        return result
    }

}

class Day(val day: Int, val count: Int)

class Meeting(var startTime: Int, var endTime: Int)

fun main() {

    var m1 = Meeting(10, 30)
    var m2 = Meeting(25, 40)
    var m3 = Meeting(41, 50)

    var input = Array(3) { m1 }
    input[1] = m2
    input[2] = m3
    input.sort()

    //println(MeetingRoom().minMeetingRoom(input))

    // println(MeetingRoom().minMeetingRooms(Array(3) { intArrayOf() }))

    println(MeetingRoom().busiestDay(intArrayOf(1, 2, 9, 5, 5), intArrayOf(4, 5, 12, 9, 12)))

}