package arrayProblems.maxConsecutiveOnes

import kotlin.math.max

/**
 * #485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *  The maximum number of consecutive 1s is 3.
 * */
class MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        // Store a running sum for growing window.
        // Store a maximum sum to capture max consecutive 1s across entire array.
        var runningSum = 0
        var maxSum = 0

        // Two pointer window problem.
        // Left pointer starts at 0
        var left = 0

        // Loop over right pointer
        for (right in nums.indices) {
            // Count sum whenever condition is still met
            if (nums[right] == 1) {
                runningSum++
                maxSum = max(runningSum, maxSum)
            }

            // While left < right && condition not met, left++
            while (left < right && nums[right] != 1) {
                if (nums[left] == 1) {
                    runningSum--
                }
                left++
            }
        }

        return maxSum
    }
}