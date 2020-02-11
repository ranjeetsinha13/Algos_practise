package arrayProblems

fun maximumWealth(accounts: Array<IntArray>): Int {
    var maxWealth = Integer.MIN_VALUE
    for (account in accounts) {
        var wealth = 0
        for (i in account.indices) {
            wealth += account[i]
        }
        if (maxWealth <= wealth) {
            maxWealth = wealth
        }
    }
    return maxWealth
}