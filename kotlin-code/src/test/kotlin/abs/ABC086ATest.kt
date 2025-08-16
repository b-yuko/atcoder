package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils.runWithInput

class ABC086ATest {
    @Test
    fun testSample1() {
        val result =
            runWithInput("3 4") {
                product()
            }
        assertEquals("Even", result.trim())
    }

    @Test
    fun testSample2() {
        val result =
            runWithInput("1 21") {
                product()
            }
        assertEquals("Odd", result.trim())
    }
}
