package arrayProblems.summaryRanges
import kotlin.math.abs

// Problem #228: https://leetcode.com/problems/summary-ranges/
// Sliding window problem
// See: https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4502/

/**
 * Example 1.
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        val solutionRanges: MutableList<String> = mutableListOf()

        if (nums.isEmpty()) {
            return solutionRanges
        }

        // Initialize the left side of the range at 0
        var left = 0

        // For loop over right pointer
        var previousRightValue = nums[0]
        for (right in nums.indices) {
            val leftValue = nums[left]
            val rightValue = nums[right]

            if (abs(rightValue - previousRightValue) > 1) {
                if (leftValue == nums[right - 1]) {
                    solutionRanges.add("$leftValue")
                } else {
                    solutionRanges.add("$leftValue->${nums[right - 1]}")
                }

                // Move to a new range by finding a new left pointer.
                // While left < right and condition is not met, iterate the left
                // side of the range after removing left side value.
                left = right
            }
            previousRightValue = rightValue
        }

        if (left == nums.size - 1) {
            solutionRanges.add("${nums.last()}")
        } else {
            solutionRanges.add("${nums[left]}->${nums.last()}")
        }
        return solutionRanges
    }
}