package arrayProblems.maxConsecutiveOnes

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class MaxConsecutiveOnesTest {
    private val testMaxConsecutiveOnes: MaxConsecutiveOnes = MaxConsecutiveOnes()

    // Map input to expected output
    private val testData = listOf(
        intArrayOf(1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1) to 28,
        intArrayOf(1,0,1,1,0,1) to 2,
        intArrayOf(1,1,0,1,1,1) to 3,
        intArrayOf(0) to 0,
        intArrayOf(1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,1,0,1,0) to 5,
        intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1) to 21,
    )

    @TestFactory
    fun testMaxConsecutiveOnes() = testData.map { (input, expected) ->
        DynamicTest.dynamicTest("Evaluating...") {
            assertEquals(expected, testMaxConsecutiveOnes.findMaxConsecutiveOnes(input))
        }
    }
}