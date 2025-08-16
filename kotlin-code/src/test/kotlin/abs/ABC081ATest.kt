package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils.runWithInput

class ABC081ATest {
    @Test
    fun testSample1() {
        val result =
            runWithInput("101") {
                placingMarbles()
            }
        assertEquals("2", result.trim())
    }

    @Test
    fun testSample2() {
        val result =
            runWithInput("000") {
                placingMarbles()
            }
        assertEquals("0", result.trim())
    }
}
