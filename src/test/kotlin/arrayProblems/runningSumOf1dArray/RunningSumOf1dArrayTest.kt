package arrayProblems.runningSumOf1dArray

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

import kotlin.test.*

internal class RunningSumOf1dArrayTest {

    private val testRunningSumOf1dArray: RunningSumOf1dArray = RunningSumOf1dArray()

    // Map input to expected output
    private val runningSumTestData = listOf(
        intArrayOf(1, 2, 3) to intArrayOf(1, 3, 6),
        intArrayOf(2, 3, 4) to intArrayOf(2, 5, 9),
        intArrayOf(0) to intArrayOf(0)
    )

    @TestFactory
    fun testRunningSum() = runningSumTestData.map {
        (input, expected) ->
        DynamicTest.dynamicTest("Evaluating..") {
            assertContentEquals(expected, testRunningSumOf1dArray.runningSum(input))
        }

    }
}