// CS 172 
// PA4Program2.java 
// PA 4 
// Written by: Ryan Schwarzkopf 
// 06/04/2022 
// Practice with nested loops, breaks, algorithms

public class PA4Program2 {

   public static void main(String[] args) {
   
      int i, num;
      boolean prime;
      
      for (num = 2; num < 1000; ++num) { // we wanna check every number to 1000 for prime
         prime = true; 
         for (i = 2; i < num; ++i) { // all numbers less than our number are candidates to be divisors
            if (num % i == 0) { // check if it is divisible
               prime = false; // if any candidate is yes, its not a prime, so break
               break;
            } // end check
         } // end divisor loop
         if (prime) { // this is if no divisors were found
            System.out.println(num);
         } // end print the prime
      } // end number loop
   
   } // end main

} // end class