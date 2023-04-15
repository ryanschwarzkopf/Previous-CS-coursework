// CS 172 
// SearchSort.java 
// PA 9
// Written by: Ryan Schwarzkopf 
// 06/24/2022 
// Algorithm Practice

import java.util.Arrays;

public class SearchSort
{

   
   public static void printIntArray(int[] array)
   {
      int i;
      for(i = 1; i <= array.length; ++i)
      {
         System.out.printf("%6d", array[i - 1]);
         System.out.print( ( i % 10 == 0 ) ? "\n" : "" );
      } // end for
   } // end printIntArray
   
   
   public static int linearSearch(int [] numbers, int key) {
      int i;
      
      for (i = 0; i < numbers.length; ++i) {
         if (numbers[i] == key) {
            return i;
         }
      }
      
      return -1; /* not found */
   }
   
   
   public static int binarySearch(int [] numbers, int key) {
      int mid;
      int low;
      int high;
      
      low = 0;
      high = numbers.length - 1;

      while (high >= low) {
         mid = (high + low) / 2;
         if (numbers[mid] < key) {
            low = mid + 1;
         } 
         else if (numbers[mid] > key) {
            high = mid - 1;
         } 
         else {
            return mid;
         }
      }

      return -1; // not found
   }
   
   
   public static void selectionSort(int [] numbers) {
      int i;
      int j;
      int indexSmallest;
      int temp;      // Temporary variable for swap

      for (i = 0; i < numbers.length - 1; ++i) {

         // Find index of smallest remaining element
         indexSmallest = i;
         for (j = i + 1; j < numbers.length; ++j) {

            if (numbers[j] < numbers[indexSmallest]) {
               indexSmallest = j;
            }
         }

         // Swap numbers[i] and numbers[indexSmallest]
         temp = numbers[i];
         numbers[i] = numbers[indexSmallest];
         numbers[indexSmallest] = temp;
      }
      printIntArray(numbers);
   }
  
   
   public static void insertionSort(int [] numbers) {
      int i;
      int j;
      int temp;      // Temporary variable for swap

      for (i = 1; i < numbers.length; ++i) {
         j = i;
         // Insert numbers[i] into sorted part 
         // stopping once numbers[i] in correct position
         while (j > 0 && numbers[j] < numbers[j - 1]) {

            // Swap numbers[j] and numbers[j - 1]
            temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            --j;
         }
      }
      printIntArray(numbers);
   }
 
      
} // end class