package arrayProblems.runningSumOf1dArray

// Problem: https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1

fun main() {
    val sol = RunningSumOf1dArray()
    val data = intArrayOf(1, 2, 3)
    val result = sol.runningSum(data)

    // Printing array
    print(result.contentToString())
}

/**
 * Problem: 1480. Running Sum of 1d Array
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1
 * */
class RunningSumOf1dArray {
    fun runningSum(nums: IntArray): IntArray {
        val sumResult = mutableListOf<Int>()

        for ((i, _) in nums.withIndex()) {
            // Slicing array
            val sumToIndex = nums.sliceArray(0..i).sum()
            sumResult.add(sumToIndex)
        }

        return sumResult.toIntArray()
    }
}