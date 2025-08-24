package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

class ABC085BTest {
    @Test
    fun case1() {
        val input = "4\n10\n8\n8\n6"
        val expected = "3"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { kagamiMochi() }

        val result = TestUtils.runWithInput(input) { kagamiMochi() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case2() {
        val input = "3\n15\n15\n15"
        val expected = "1"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { kagamiMochi() }

        val result = TestUtils.runWithInput(input) { kagamiMochi() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case3() {
        val input = "7\n50\n30\n50\n100\n50\n80\n30"
        val expected = "4"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { kagamiMochi() }

        val result = TestUtils.runWithInput(input) { kagamiMochi() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case4() {
        val input = "7\n50\n30\n50\n100\n50\n80\n30"
        val expected = "4"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { countUniqueMochi() }

        val result = TestUtils.runWithInput(input) { countUniqueMochi() }
        assertEquals(expected, result.trim())
    }
}









