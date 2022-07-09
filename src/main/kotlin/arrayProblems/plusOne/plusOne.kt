package arrayProblems.plusOne
import kotlin.math.pow
import kotlin.math.floor

// Leetcode 66. Plus One
// https://leetcode.com/problems/plus-one/

fun plusOneFail(digits: IntArray): IntArray {
    /* Note - This function fails with the input [6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3] b/c the sum is too large
    for the Int type.
    * */
    var sum = 0
    var power: Double = digits.size.toDouble() - 1.0
    var newMultiplier: Int
    var newValue: Int
    val numberAsArray: MutableList<Int> = mutableListOf<Int>()
    var i = 0
    val basePower = 10.0
    for (n in digits) {
        // Get new values using power
        newMultiplier = basePower.pow(power).toInt()
        newValue = n * newMultiplier

        // Calculate the sum
        sum += newValue

        // Iterate
        i += 1
        power -= 1
    }

    // Add 1 to the original total, as instructed
    sum += 1

    // Create array of new sum value
    var remainder: Double
    while (sum >= 1.0) {
        // Add the values to the array
        remainder = sum.toDouble() % 10
        numberAsArray.add(remainder.toInt())

        // Calculate the sum by "popping" a value from the single digits place
        sum = floor(sum / 10.0).toInt()
        // sum = sum.toInt().floorDiv(10).toDouble()
    }
    // Reverse the ordering
    numberAsArray.reverse()
    return numberAsArray.toIntArray()
}

fun plusOne(digits: IntArray): IntArray {

    val finalValue: MutableList<Int> = digits.toMutableList()

    // Discover if a "carryover" with addition of the +1 value is required, such as [9, 9] + 1 = [1, 0, 0].
    var carryoverToIndex = finalValue.size - 1  // assume carryover index starts in the final index.
    var carryover: Int = finalValue[carryoverToIndex] - 8  // This is the initial carryover from the one's position (there can be more)

    // Iterate to discover if the initial carryover triggers more carryover. Find the position, i, where the
    // carryover can be added without causing another carryover to the next position. This position is found
    // when finalValue[i] - 8 > 0
    while (carryover > 0) {  // When carryover <= 0, then we know there are no more positions that can hold the +1.
        // When carryover is required when +1 in a position, then zero that position, and go to the next position up.
        finalValue[carryoverToIndex] = 0
        carryoverToIndex -= 1  // Go to the next position up, which may be able to hold the carryover if it is below 9

        // Calculate
        if (carryoverToIndex < 0) {
            // This is the case where the carryover is from the last index, and there is no additional positions
            // to carry the +1 value.
            carryover = finalValue[finalValue.size - 1] - 8
        } else {
            // This is the next level of carryover, e.g. [9, 9] + 1 = [1, 0, 0] has 2 levels of carryover.
            carryover = finalValue[carryoverToIndex] - 8
        }

    }

    if (carryoverToIndex >= 0) {
        // Once the carryover is complete, add +1 to the position where the carryover "lands".
        finalValue[carryoverToIndex] += 1
    } else {
        // If the ending index is < 0, then we have to add a new position to the list.
        // This is for inputs such as [9] + 1 = [1, 0] and [9, 9] + 1 = [1, 0, 0]
        finalValue.add(0)
        finalValue[0] = 1
    }

    return finalValue.toIntArray()
}


fun main() {
    val result: IntArray
    // val input: IntArray = intArrayOf(4,3,2,9)
    val input: IntArray = intArrayOf(9, 9)
    // val input: IntArray = intArrayOf(6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3)
    result = plusOne(digits = input)
    println(result.contentToString())
}
