
function fib(n) {
 let fib = Array(n+1).fill(0)
 fib[1] = 1
 for(i = 0; i < n;i++) {
    fib[i+1] += fib[i] // fib[n] = fib[n-1] + fib[n-2].. this is fib[n-1]
    fib[i+2] += fib[i] // fib[n] = fib[n-1] + fib[n-2].. this is fib[n-2]
 }
 return fib[n];
}

console.log(fib(2));
console.log(fib(3));
console.log(fib(4));
console.log(fib(5));
console.log(fib(6));
console.log(fib(7));
console.log(fib(8));
console.log(fib(18));
console.log(fib(28));
console.log(fib(38));
console.log(fib(48));
console.log(fib(50));
//262144 - 64^3