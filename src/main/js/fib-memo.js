function fib(n, memo={}) {
    if(n==1 || n==2) return 1;
    if(n in memo) {
         console.log('return from memoization' + n)
        return memo[n];
    }
    memo[n] = fib(n-1, memo) + fib(n-2, memo)
    return memo[n] ;
}

console.log(fib(8));
console.log(fib(18));
console.log(fib(28));
console.log(fib(38));
console.log(fib(48));