import java.util.*

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

}

class Meeting(var startTime: Int, var endTime: Int)

fun main() {

    var m1 = Meeting(10, 30)
    var m2 = Meeting(25, 40)
    var m3 = Meeting(41, 50)

    var input = Array(3) { m1 }
    input[1] = m2
    input[2] = m3

    println(MeetingRoom().minMeetingRoom(input))

    println(MeetingRoom().minMeetingRooms(Array(3) { intArrayOf() }))

}