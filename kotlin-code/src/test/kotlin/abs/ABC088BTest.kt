package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

class ABC088BTest {
    @Test
    fun case1() {
        val input = "2\n3 1"
        val expected = "2"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { cardGameForTwo() }

        val result = TestUtils.runWithInput(input) { cardGameForTwo() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case2() {
        val input = "3\n2 7 4"
        val expected = "5"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { cardGameForTwo() }

        val result = TestUtils.runWithInput(input) { cardGameForTwo() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case3() {
        val input = "4\n20 18 2 18"
        val expected = "18"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { cardGameForTwo() }

        val result = TestUtils.runWithInput(input) { cardGameForTwo() }
        assertEquals(expected, result.trim())
    }
}