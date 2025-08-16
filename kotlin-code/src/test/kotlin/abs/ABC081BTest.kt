package abs

import org.junit.jupiter.api.Test
import utils.TestUtils
import utils.testCase

class ABC081BTest {
    @Test
    fun testAllCases() {
        val testCases =
            listOf(
                testCase("3\n8 12 40", "2"),
                testCase("4\n5 6 8 10", "0"),
                testCase("6\n382253568 723152896 37802240 379425024 404894720 471526144", "8"),
            )

        TestUtils.assertTestCases(testCases) { shiftOnly() }
    }
}
