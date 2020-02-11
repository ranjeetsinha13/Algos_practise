package arrayProblems

class RunningSum {
    // Space Complexity O(N)
    // Time Complexity O(N^2)
    fun runningSum(nums: IntArray): IntArray {
        var arr = IntArray(nums.size)
        for (i in nums.indices) {
            var sum = 0
            for(j in 0..i) {
                sum+=nums[j]
            }
            arr[i] = sum
        }
        return arr
    }

    //[1,2,3,4,5] -> [1,3,6,10,15]
    fun runningSumOptimised(nums: IntArray): IntArray {
        var preSum =0
        for (i in nums.indices) {
            val sum = nums[i] + preSum
            nums[i] = sum
            preSum = sum
        }
        return nums
    }
}