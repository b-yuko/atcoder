package abs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import utils.TestUtils
import utils.TestUtils.runWithInput
import utils.testCase

class PracticeATest {
    @Test
    fun testSample1() {
        val result =
            runWithInput("1\n2 3\ntest") {
                practiceA()
            }
        assertEquals("6 test", result.trim())
    }

    @Test
    fun testSample2() {
        val result =
            runWithInput("72\n128 256\nmyonmyon") {
                practiceA()
            }
        assertEquals("456 myonmyon", result.trim())
    }

    @Test
    fun testAllCases() {
        val testCases =
            listOf(
                testCase("1\n2 3\ntest", "6 test"),
                testCase("72\n128 256\nmyonmyon", "456 myonmyon"),
                testCase("0\n0 0\nhello", "0 hello"),
            )

        val results = TestUtils.runTestCases(testCases) { practiceA() }

        // 全て成功したかチェック
        val allPassed = results.all { it.second }
        assertTrue(allPassed, "Some test cases failed")

        // 失敗したケースの詳細を表示
        results.filter { !it.second }.forEach { (message, _) ->
            println("Failed: $message")
        }
    }

    @Test
    fun testAllCases2() {
        val testCases =
            listOf(
                testCase("1\n2 3\ntest", "6 test"),
                testCase("72\n128 256\nmyonmyon", "456 myonmyon"),
                testCase("0\n0 0\nhello", "0 hello"), // 仮に失敗するケース
            )

        // この関数を使うと失敗時に詳細が見える
        TestUtils.assertTestCases(testCases) { practiceA() }
    }
}
