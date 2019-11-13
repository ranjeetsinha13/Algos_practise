class Paranthesis {
    fun generateParenthesis(n: Int): List<String> {
        var ans = mutableListOf<String>()
        backTrack(ans, "", 0, 0, n)
        return ans

    }


    private fun backTrack(ans: MutableList<String>, curr: String, open: Int, close: Int, n: Int) {
        if (curr.length == 2 * n) {
            ans.add(curr)
            return
        }
        if (open < n) {
            backTrack(ans, "$curr(", open + 1, close, n)
        }
        if (close < open) {
            backTrack(ans, "$curr)", open, close + 1, n)
        }
    }
}

fun main() {
    println(Paranthesis().generateParenthesis(2))
}