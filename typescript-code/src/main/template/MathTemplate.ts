/*

// 最大公約数 (Greatest Common Divisor)
function gcd(a: number, b: number): number {
    return b === 0 ? a : gcd(b, a % b);
}

// 最小公倍数 (Least Common Multiple)
function lcm(a: number, b: number): number {
    return a / gcd(a, b) * b;
}

// 素数判定
function isPrime(n: number): boolean {
    if (n < 2) return false;
    if (n === 2) return true;
    if (n % 2 === 0) return false;

    for (let i = 3; i * i <= n; i += 2) {
        if (n % i === 0) return false;
    }
    return true;
}

// n以下の素数一覧（エラトステネスの篩）
function sieve(n: number): number[] {
    const isPrime = new Array(n + 1).fill(true);
    isPrime[0] = isPrime[1] = false;

    for (let i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return Array.from({length: n + 1}, (_, i) => i).filter(i => isPrime[i]);
}

// 約数の個数を数える
function countDivisors(n: number): number {
    let count = 0;
    for (let i = 1; i * i <= n; i++) {
        if (n % i === 0) {
            count++;
            if (i * i !== n) count++;
        }
    }
    return count;
}

// 約数の一覧を取得
function getDivisors(n: number): number[] {
    const divisors: number[] = [];
    for (let i = 1; i * i <= n; i++) {
        if (n % i === 0) {
            divisors.push(i);
            if (i * i !== n) divisors.push(n / i);
        }
    }
    return divisors.sort((a, b) => a - b);
}

// x を n 回割ったときの回数（ABC081B - Shift Only用）
function divideCount(x: number, n: number): number {
    let count = 0;
    while (x % n === 0) {
        x /= n;
        count++;
    }
    return count;
}

// べき乗（繰り返し二乗法）
function pow(base: number, exp: number, mod = Number.MAX_SAFE_INTEGER): number {
    let result = 1;
    base %= mod;

    while (exp > 0) {
        if (exp % 2 === 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp = Math.floor(exp / 2);
    }
    return result;
}

// 階乗
function factorial(n: number): number {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

// 順列 nPr
function permutation(n: number, r: number): number {
    if (r > n) return 0;
    let result = 1;
    for (let i = n - r + 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

// 組み合わせ nCr
function combination(n: number, r: number): number {
    if (r > n || r < 0) return 0;
    if (r === 0 || r === n) return 1;

    r = Math.min(r, n - r); // 計算量を減らすため

    let result = 1;
    for (let i = 0; i < r; i++) {
        result = result * (n - i) / (i + 1);
    }
    return Math.floor(result);
}

 */