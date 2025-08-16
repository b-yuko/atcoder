package abs

import org.junit.jupiter.api.Test
import utils.TestUtils
import utils.testCase

class ABC087BTest {
    @Test
    fun testAllCases() {
        val testCases =
            listOf(
                testCase("2\n2\n2\n100", "2"),
                testCase("5\n1\n0\n150", "0"),
                testCase("30\n40\n50\n6000", "213"),
            )

        TestUtils.assertTestCases(testCases) { coins() }
    }

    @Test
    fun testAllCases2() {
        val testCases =
            listOf(
                testCase("2\n2\n2\n100", "2"),
                testCase("5\n1\n0\n150", "0"),
                testCase("30\n40\n50\n6000", "213"),
            )

        TestUtils.assertTestCases(testCases) { coins2() }
    }
}
