## BackTracking

* [Combinatorial Search and For-Expressions](https://www.coursera.org/lecture/progfun1/lecture-6-2-combinatorial-search-and-for-expressions-JIPKx)

```scala
object PrimeFactors extends App {
val N: Int = 8;

def isPrime(n: Int): Boolean = Range(2, n).filter(k => n % k == 0).seq.size == 0

val pairs = for {
    i <- 1 until N
    j <- 1 until i
    if isPrime(i + j)
} yield (i, j)

print(pairs)
}
```
