import java.util.*

class MaxBurgerDeliveryHero {

    fun maxBurger(x: Int, y: Int): IntArray {

        var a = intArrayOf(-1, -1)

        val maxSmallBurger = (y / 2).coerceAtMost(x)

        val resourceLeftY = y - maxSmallBurger * 2

        if (resourceLeftY == 0) {
            a[0] = maxSmallBurger
            a[1] = 0
        } else {
            a[0] = maxSmallBurger - resourceLeftY / 2
            a[1] = resourceLeftY / 2
        }

        if (a[0] * 2 + a[1] * 4 - y != 0) {
            a[0] = -1
            a[1] = -1
        }

        return a


    }
}

fun main() {

    println(MaxBurgerDeliveryHero().maxBurger(7, 19).contentToString())

}