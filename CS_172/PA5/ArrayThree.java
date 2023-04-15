// CS 172 
// ArrayThree.java 
// PA 5 
// Written by: Ryan Schwarzkopf 
// 06/10/2022 
// Practice using Arrays, getting file input, and debugging

import java.util.Scanner;
import java.io.*;

public class ArrayThree {

   public static void main(String[] args) throws IOException {
      
      String[] array3 = new String[10]; // array of 10 strings
      Scanner filename = new Scanner(new File("stringsC.txt")); // making a scanner for a file
      
      int i = 0; // i is to count for the break statement below and to find the amount of strings in array3 if the file is short
      while (filename.hasNext()) { 
         array3[i] = filename.nextLine();
         i++;
         if(i == 10 || !(filename.hasNextLine())) { // checking if i is outside index range for array3 OR the file has no more lines and break the loop if true
            break;
         }
      }
      
      String longestLine = array3[0]; // initializing longestLine as the first element of array3
      int j;
      for (j = 1; j < i; ++j) { // starting at index 1 and going up to the length of the array that is filled (i) we check for if longestLine is greater than the element
         if (array3[j].length() > longestLine.length())
            longestLine = array3[j];
      }
      System.out.println("The length of the longest string in the file = " + longestLine.length());
   
   } // end main
} // end class