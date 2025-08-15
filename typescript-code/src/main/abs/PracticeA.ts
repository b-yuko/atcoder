export function practiceA(input: string): void {
  const lines = input.split("\n");
  const a = parseInt(lines[0], 10);
  const [b, c] = lines[1].split(" ").map(Number);
  const s = lines[2];
  console.log(`${a + b + c} ${s}`);
}

// practiceA(require("fs").readFileSync("/dev/stdin", "utf8"));
// ↑ テスト実行時はコメントアウトする ↑
