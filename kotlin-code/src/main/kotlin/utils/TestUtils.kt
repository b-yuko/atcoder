package utils

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * デバッグ用のグローバルフラグとヘルパー関数
 */
object Debug {
    // テスト実行時にのみデバッグ出力を有効化
    var enabled = false

    /**
     * デバッグ出力（テスト時のみ表示）
     */
    fun println(message: Any?) {
        if (enabled) {
            System.err.println("Debug: $message") // 標準エラーに出力
        }
    }

    /**
     * デバッグ出力（ラベル付き）
     */
    fun println(
        label: String,
        value: Any?,
    ) {
        if (enabled) {
            System.err.println("Debug: $label = $value") // 標準エラーに出力
        }
    }

    /**
     * 配列やリストの内容をデバッグ出力
     */
    fun printArray(
        label: String,
        array: Any,
    ) {
        if (enabled) {
            when (array) {
                is IntArray -> System.err.println("Debug: $label = [${array.joinToString(", ")}]")
                is LongArray -> System.err.println("Debug: $label = [${array.joinToString(", ")}]")
                is DoubleArray -> System.err.println("Debug: $label = [${array.joinToString(", ")}]")
                is Array<*> -> System.err.println("Debug: $label = [${array.joinToString(", ")}]")
                is List<*> -> System.err.println("Debug: $label = [${array.joinToString(", ")}]")
                else -> System.err.println("Debug: $label = $array")
            }
        }
    }

    /**
     * 区切り線を出力
     */
    fun separator(title: String = "") {
        if (enabled) {
            if (title.isNotEmpty()) {
                System.err.println("Debug: === $title ===")
            } else {
                System.err.println("Debug: ================")
            }
        }
    }

    /**
     * ステップ実行的なデバッグ（処理の進行状況を表示）
     */
    fun step(
        stepNumber: Int,
        description: String,
    ) {
        if (enabled) {
            System.err.println("Debug: Step $stepNumber: $description")
        }
    }
}

/**
 * AtCoder用テストユーティリティ（デバッグ出力対応版）
 * 標準入出力を使った関数のテストを簡単にする
 */
object TestUtils {
    /**
     * 指定した入力で関数を実行し、標準出力の内容を返す
     * デバッグモードが有効な場合、Debug.enabledを自動設定
     */
    fun runWithInput(
        input: String,
        debugMode: Boolean = false,
        showInputOutput: Boolean = true,
        block: () -> Unit,
    ): String {
        val originalIn = System.`in`
        val originalOut = System.out
        val originalDebugState = Debug.enabled

        try {
            // デバッグモード設定
            Debug.enabled = debugMode

            // 入力設定
            System.setIn(ByteArrayInputStream(input.toByteArray()))
            val outputStream = ByteArrayOutputStream()
            System.setOut(PrintStream(outputStream))

            // 処理実行
            block()
            val output = outputStream.toString()

            // デバッグ情報表示
            if (debugMode && showInputOutput) {
                // 出力を元に戻してからデバッグ情報を表示
                System.setOut(originalOut)

                Debug.separator("INPUT/OUTPUT")
                println("Input:")
                input.lines().forEachIndexed { index, line ->
                    println("  ${index + 1}: '$line'")
                }
                println("\nOutput:")
                output.lines().filter { it.isNotEmpty() }.forEachIndexed { index, line ->
                    println("  ${index + 1}: '$line'")
                }
                Debug.separator()
            }

            return output
        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
            Debug.enabled = originalDebugState
        }
    }

    /**
     * デバッグモード付きの複数テストケース実行
     */
    fun runTestCasesWithDebug(
        testCases: List<Pair<String, String>>,
        debugMode: Boolean = true,
        block: () -> Unit,
    ): List<Pair<String, Boolean>> =
        testCases.mapIndexed { index, (input, expected) ->
            if (debugMode) {
                println("\n" + "=".repeat(50))
                println("TEST CASE ${index + 1}")
                println("=".repeat(50))
            }

            val result = runWithInput(input, debugMode, block = block)
            val actual = result.trim()
            val success = actual == expected

            if (debugMode) {
                println("Expected: '$expected'")
                println("Actual:   '$actual'")
                println("Status:   ${if (success) "✓ PASS" else "✗ FAIL"}")
                if (!success) {
                    println("❌ MISMATCH DETECTED!")
                }
            }

            Pair("Expected: $expected, Actual: $actual", success)
        }

    /**
     * 単一テストケースのクイックデバッグ
     */
    fun quickDebug(
        input: String,
        expected: String? = null,
        block: () -> Unit,
    ) {
        println("🔍 QUICK DEBUG MODE")
        println("Input: $input")
        expected?.let { println("Expected: $it") }
        println("-".repeat(30))

        val result = runWithInput(input, debugMode = true, block = block)
        val actual = result.trim()

        println("-".repeat(30))
        println("Result: '$actual'")

        expected?.let {
            val match = actual == it
            println("Match: ${if (match) "✓" else "✗"}")
        }
    }

    // 既存のメソッドとの互換性を保つため
    fun runWithInput(
        input: String,
        block: () -> Unit,
    ): String = runWithInput(input, false, true, block)

    fun runTestCases(
        testCases: List<Pair<String, String>>,
        solver: () -> Unit,
    ): List<Pair<String, Boolean>> = runTestCasesWithDebug(testCases, false, solver)

    /**
     * 複数のテストケースを実行して、失敗したケースの詳細を表示
     * JUnitのassertEqualsの代わりに例外を投げる
     */
    fun assertTestCases(
        testCases: List<Pair<String, String>>,
        solver: () -> Unit,
    ) {
        testCases.forEachIndexed { index, (input, expected) ->
            val result = runWithInput(input, block = solver)
            val actual = result.trim()

            if (actual != expected) {
                println("=== Test case ${index + 1} FAILED ===")
                println("Input:")
                println(input)
                println("Expected: '$expected'")
                println("Actual:   '$actual'")
                println("=====================================")

                // JUnitの代わりに例外を投げる
                throw AssertionError("Test case ${index + 1} failed.\nInput:\n$input\nExpected: $expected\nActual: $actual")
            }
        }
    }
}

/**
 * 便利な拡張関数
 */
fun String.debug(label: String = "Value") {
    Debug.println(label, this)
}

fun Int.debug(label: String = "Int") {
    Debug.println(label, this)
}

fun Long.debug(label: String = "Long") {
    Debug.println(label, this)
}

fun <T> List<T>.debug(label: String = "List") {
    Debug.printArray(label, this)
}

fun IntArray.debug(label: String = "IntArray") {
    Debug.printArray(label, this)
}

fun LongArray.debug(label: String = "LongArray") {
    Debug.printArray(label, this)
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
