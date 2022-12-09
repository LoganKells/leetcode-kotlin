package arrayProblems.summaryRanges

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertContentEquals

class SummaryRangesTest {
    private val testSummaryRanges: SummaryRanges = SummaryRanges()

    // Map input to expected output
    private val testData = listOf(
        intArrayOf(-2147483648,-2147483647,2147483647) to listOf("-2147483648->-2147483647","2147483647"),
        intArrayOf(0, 1, 2, 4, 5, 7) to listOf("0->2","4->5","7"),
        intArrayOf(0,2,3,4,6,8,9) to listOf("0","2->4","6","8->9"),
        intArrayOf(0,1,2,4,5,7,20) to listOf("0->2","4->5","7","20"),
        intArrayOf() to listOf(),
    )

    @TestFactory
    fun testSummaryRanges() = testData.map {
        (input, expected) ->
        DynamicTest.dynamicTest("Evaluating...") {
            assertContentEquals(expected, testSummaryRanges.summaryRanges(input))
        }
    }
}