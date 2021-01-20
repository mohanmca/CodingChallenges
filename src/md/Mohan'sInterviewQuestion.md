## We get  n sets of m integers, those m integers are sorted already, How do you get the combined sorted elements

* Example Inputs : [2,4,15,111,2123,3154,4210], [1,4,5,10,12,15,20], [1,3,5,11,123,154,210]


## How to find k th largest element from Array

* Example Inputs : [2,4,15,111,2123,3154,4210, 1,4,5,10,12,15,20]

## How to find largest Prime factor of a number

* Largest prime factor of number '6' is 3
* highest prime factor of number '15' is 5
* Biggest prime factor of number '392832' is 31
* Largest prime factor of number '1787866' is 893933

## 












 // Java Program to find largest 
// prime factor of number 
import java.io.*; 
import java.util.*; 

class GFG { 

	// function to find largest prime factor 
	static long maxPrimeFactors(long n) 
	{ 
		// Initialize the maximum prime 
		// factor variable with the 
		// lowest one 
		long maxPrime = -1; 

		// Print the number of 2s 
		// that divide n 
		while (n % 2 == 0) { 
			maxPrime = 2; 

			// equivalent to n /= 2 
			n >>= 1; 
		} 

		// n must be odd at this point, 
		// thus skip the even numbers 
		// and iterate only for odd 
		// integers 
		for (int i = 3; i <= Math.sqrt(n); i += 2) { 
			while (n % i == 0) { 
				maxPrime = i; 
				n = n / i; 
			} 
		} 

		// This condition is to handle 
		// the case when n is a prime 
		// number greater than 2 
		if (n > 2) 
			maxPrime = n; 

		return maxPrime; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Long n = 15l; 
		System.out.println(maxPrimeFactors(n)); 

		n = 25698751364526l; 
		System.out.println(maxPrimeFactors(n)); 
	} 
} 

// This code is contributed by Gitanjali 
