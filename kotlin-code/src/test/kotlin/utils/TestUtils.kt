package utils

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * AtCoder用テストユーティリティ
 * 標準入出力を使った関数のテストを簡単にする
 */
object TestUtils {
    /**
     * 指定した入力で関数を実行し、標準出力の内容を返す
     *
     * @param input 標準入力に渡すデータ（改行は \n で区切る）
     * @param block 実行する関数
     * @return 標準出力の内容（文字列）
     */
    fun runWithInput(
        input: String,
        block: () -> Unit,
    ): String {
        val originalIn = System.`in`
        val originalOut = System.out

        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            block()
            return outputStream.toString()
        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }

    /**
     * 複数のテストケースを一括実行するヘルパー
     *
     * @param testCases テストケースのペア（入力, 期待される出力）のリスト
     * @param solver テスト対象の関数
     */
    fun runTestCases(
        testCases: List<Pair<String, String>>,
        solver: () -> Unit,
    ): List<Pair<String, Boolean>> =
        testCases.map { (input, expected) ->
            val result = runWithInput(input, solver)
            val actual = result.trim()
            val success = actual == expected
            Pair("Expected: $expected, Actual: $actual", success)
        }

    /**
     * 複数のテストケースを実行して、失敗したケースの詳細を表示
     * 各テストケースを個別にアサーションする
     *
     * @param testCases テストケースのペア（入力, 期待される出力）のリスト
     * @param solver テスト対象の関数
     */
    fun assertTestCases(
        testCases: List<Pair<String, String>>,
        solver: () -> Unit,
    ) {
        testCases.forEachIndexed { index, (input, expected) ->
            val result = runWithInput(input, solver)
            val actual = result.trim()

            if (actual != expected) {
                println("=== Test case ${index + 1} FAILED ===")
                println("Input:")
                println(input)
                println("Expected: '$expected'")
                println("Actual:   '$actual'")
                println("=====================================")
            }

            // 個別にアサーション（失敗時に詳細な情報が出る）
            org.junit.jupiter.api.Assertions.assertEquals(
                expected,
                actual,
                "Test case ${index + 1} failed.\nInput:\n$input",
            )
        }
    }
}

/**
 * 拡張関数として使いやすくする
 */
fun String.asInput(block: () -> Unit): String = TestUtils.runWithInput(this, block)

/**
 * テストケース作成のヘルパー
 */
fun testCase(
    input: String,
    expected: String,
): Pair<String, String> = Pair(input, expected)
