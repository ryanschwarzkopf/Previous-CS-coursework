// CS 172 
// PA4Program1.java 
// PA 4 
// Written by: Ryan Schwarzkopf 
// 06/04/2022 
// Practice using String methods

import java.util.Scanner;

public class PA4Program1 {

   public static void main(String[] args) {
   
      Scanner scnr = new Scanner(System.in);
      
      // 1) for/while loops to print the odd numbers from 1 to 99 (inclusive)
      int i;
      for (i = 1; i <= 99; i = i + 2) { // using for loop, just printing i, starting odd and adding two
         System.out.println(i);
      } // end for
      i = 1; // reset i
      while(i < 100) { // same concept with while loop
         System.out.println(i);
         i = i + 2;
      } // end while
      
      // 2) for/while loop that will input 10 integer values from the user and keep track of the largest value entered
      
      scnr.nextLine(); // for clarity & throw away a line
      
      int num;
      int max = 0;
      for (i = 0; i < 10; i++) { // for loop repeating 10 times
         System.out.println("Enter a number: ");
         num = scnr.nextInt();
         if (num > max) { // check if number is higher
            max = num;
         } // end check/rename
      } // end for
      System.out.println("The maximum number you entered was: " + max);
      
      max = 0;
      i = 0;
      while (i < 10) { // same concept with while loop
         System.out.println("Enter a number: ");
         num = scnr.nextInt();
         if (num > max) {
            max = num;
         } // end check/rename
         i = i + 1;
      } // end loop
      System.out.println("The maximum number you entered was: " + max);
      
      // 3) nested for/while loop that prints the number of each vowel in the user's input
      
      scnr.nextLine(); // for clarity and throw away a line
      
      System.out.println("Enter a string: ");
      String str = scnr.nextLine();
      str = str.toLowerCase();
      char[] vowels = {'a', 'e', 'i', 'o', 'u'};
      int j;
      int count;
      
      // with for loops
      for(i = 0; i < vowels.length; ++i) { // were using a loop with the array to check all the vowels to keep code short
         count = 0;
         for (j = 0; j < str.length(); ++j) { // for every index..  
            if (str.charAt(j) == vowels[i]) { // check for vowel
               count += 1;
            } // end check/rename
         } // end index loop
         System.out.println("Number of " + vowels[i] + "'s is: " + count);
      } // end vowels loop
      
      
      System.out.println("Enter a string: ");
      str = scnr.nextLine();
      str = str.toLowerCase();
      i = 0;
      
      while(i < vowels.length) { //same concept with while loops lol. This way really sucks to keep track of when to reset/add i, count and j
         count = 0;
         j = 0;
         while (j < str.length()) {   
            if (str.charAt(j) == vowels[i]) {
               count = count + 1;
            }
            j = j + 1;
         }
         System.out.println("Number of " + vowels[i] + "'s is: " + count);
         i = i + 1;
      }

      
   } // end main

} // end class