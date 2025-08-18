package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

class ABC083BTest {
    @Test
    fun case1() {
        val input = "20 2 5"
        val expected = "84"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { someSums() }

        val result = TestUtils.runWithInput(input) { someSums() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case2() {
        val input = "10 1 2"
        val expected = "13"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { someSums() }

        val result = TestUtils.runWithInput(input) { someSums() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case3() {
        val input = "100 4 16"
        val expected = "4554"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { someSums() }

        val result = TestUtils.runWithInput(input) { someSums() }
        assertEquals(expected, result.trim())
    }
}