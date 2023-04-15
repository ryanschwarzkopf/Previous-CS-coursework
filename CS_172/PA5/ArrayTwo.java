// CS 172 
// ArrayTwo.java 
// PA 5 
// Written by: Ryan Schwarzkopf 
// 06/10/2022 
// Practice using Arrays

import java.util.Scanner;

public class ArrayTwo {

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int[] array2 = new int[20];  
      int i;      
      for(i = 0; i < 20; ++i) { // go through each index...
         array2[i] = (int)((Math.random() * 100) + 1); // random between 0(inclusive) and 1(exclusive)..times 100 to get the range (0-99), and plus 1(1-100)
      }
      
      System.out.println("Even numbers in array2:");
      for(i = 0; i < 20; ++i) { // for all indexes..
         if(array2[i] % 2 == 0) // see if divisible by 2 (evens)
            System.out.print(array2[i] + " ");
      }
      
      System.out.println(); // new line for space
      
      array2[13] = array2[14] + 1; // changing element 14 (index 13) by adding 1
      
      int max = array2[0];
      int min = array2[0];
      
      for(i = 1; i < 20; ++i) { // we can start at index 1, because index 0 is already set as min & max
         if(array2[i] > max)
            max = array2[i];
         else if(array2[i] < min) // if index was max, we can skip check for min.. so use else if.
            min = array2[i];
      }
      System.out.print("Max is " + max + " min is " + min);
      
   
   }
}