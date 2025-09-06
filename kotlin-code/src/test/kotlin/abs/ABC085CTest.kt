package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

class ABC085CTest {
    @Test
    fun case1() {
        val input = "9 45000"
        val expected = "4 0 5"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { otoshidama() }

        val result = TestUtils.runWithInput(input) { otoshidama() }
        assertEquals(expected, result.trim())
    }
}