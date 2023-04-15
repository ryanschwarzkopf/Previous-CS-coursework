// CS 172 
// ArrayOne.java 
// PA 5 
// Written by: Ryan Schwarzkopf 
// 06/10/2022 
// Practice using Arrays

import java.util.Scanner;

public class ArrayOne {

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int[] array1 = new int[50];  
      int i;      
      for(i = 0; i < 50; ++i) { // go through each index...
         array1[i] = (int)((Math.random() * 1000) + 1); // random between 0(inclusive) and 1(exclusive)..times 1000 to get the range (0-999), and plus 1(1-1000)
      }
      
      // 10 per line forward
      System.out.println("Contents of array1:");
      for(i = 1; i <= array1.length; ++i) { // start with i=1 to avoid i%10 boolean from being true at index 0
         System.out.printf("%5d", array1[i - 1]); // subtract 1 because we made i=1 but we want to start at index 0. %5d formats 5 spaces between array, it is automatically right-justified
         if (i % 10 == 0) { // after the 10th index is printed, print a new line
            System.out.println();
         }
      }
      System.out.println();
      
      // 5 per line forward. Same exact code, except line 35 is changed
      System.out.println("Contents of array 1, 5 elements per line:");
      for(i = 1; i <= array1.length; ++i) {
         System.out.printf("%5d", array1[i - 1]);
         if (i % 5 == 0) { // changed to 5 for every fifth index we want a new line
            System.out.println();
         }
      }
      System.out.println();
      
      // 10 per line backwards
      System.out.println("Reversed contents of array 1, 10 elements per line:");
      for(i = array1.length - 1; i >= 0; --i) { // now we start with the highest index and go down. The biggest is 49, so %5 problem before is okay
         System.out.printf("%5d", array1[i]);
         if (i % 10 == 0) { // changing back to 10 per line
            System.out.println();
         }
      }
      System.out.println();

   } // end main
} // end class