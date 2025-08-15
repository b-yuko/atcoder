/*

********** 基本的な入力パターン **********

// 1つの整数
const n = parseInt(lines[0]);

// 1つの長整数 (BigInt)
const n = BigInt(lines[0]);

// スペース区切りの整数リスト
const nums = lines[0].split(" ").map(Number);

// スペース区切りの長整数リスト
const nums = lines[0].split(" ").map(BigInt);

// 2つの整数 (a, b)
const [a, b] = lines[0].split(" ").map(Number);

// 3つの整数 (a, b, c)
const [a, b, c] = lines[0].split(" ").map(Number);

// 文字列
const s = lines[0];

// 複数行の入力例
const n = parseInt(lines[0]);
const items = lines.slice(1, n + 1).map(Number);


********** よく使う処理パターン **********

// 配列の最大値・最小値
const maxValue = Math.max(...nums);
const minValue = Math.min(...nums);

// 配列の合計
const sum = nums.reduce((acc, cur) => acc + cur, 0);

// 文字列を文字の配列に
const chars = s.split('');

// 文字列の各文字をチェック
for (const char of s) {
    // 処理
}

// 条件に一致する要素をカウント
const count = nums.filter(x => x > 0).length;

// 配列のソート
nums.sort((a, b) => a - b); // 昇順
nums.sort((a, b) => b - a); // 降順

// 文字列の置換
const s = "hello world";
const replaced = s.replace(/l/g, 'x'); // 全てのlをxに

// 文字コード変換
const charCode = 'a'.charCodeAt(0); // 97
const char = String.fromCharCode(97); // 'a'

// 配列の初期化
const arr1 = new Array(n).fill(0); // 0で初期化
const arr2 = Array.from({length: n}, (_, i) => i); // [0,1,2,...]

// 2次元配列の初期化
const matrix = Array.from({length: h}, () => new Array(w).fill(0));

// Set（重複除去）
const uniqueNums = [...new Set(nums)];

// Map（辞書）
const map = new Map<string, number>();
map.set('key', 1);
const value = map.get('key') || 0;

 */