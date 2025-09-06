package abc.a

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

class ABC421ATest {
    @Test
    fun case1() {
        val input = "3\nsato\nsuzuki\ntakahashi\n3 takahashi"
        val expected = "Yes"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { misdelivery() }

        val result = TestUtils.runWithInput(input) { misdelivery() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case2() {
        val input = "3\nsato\nsuzuki\ntakahashi\n1 aoki"
        val expected = "No"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { misdelivery() }

        val result = TestUtils.runWithInput(input) { misdelivery() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case3() {
        val input = "2\nsmith\nsmith\n1 smith"
        val expected = "Yes"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { misdelivery() }

        val result = TestUtils.runWithInput(input) { misdelivery() }
        assertEquals(expected, result.trim())
    }

    @Test
    fun case4() {
        val input = "2\nwang\nli\n2 wang"
        val expected = "No"

        TestUtils.quickDebug(
            input = input,
            expected = expected,
        ) { misdelivery() }

        val result = TestUtils.runWithInput(input) { misdelivery() }
        assertEquals(expected, result.trim())
    }
}