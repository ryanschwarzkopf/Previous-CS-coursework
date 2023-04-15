// CS 172 
// PA9test.java 
// PA 9
// Written by: Ryan Schwarzkopf 
// 06/24/2022 
// Algorithm Practice

public class PA9Test 
{


   public static void main(String[] args) 
   {    
      // making array1
      int[] array1 = new int[50];     
      int i;
      for(i = 0; i < array1.length; ++i) 
      {
         array1[i] = (int)((Math.random() * 100) + 1);
      } // end for
      
      // declaring SearchSort object
      SearchSort javaSearch = new SearchSort(); 
      
      // printIntArray test
      System.out.println("Array 1 - unsorted:\n");
      javaSearch.printIntArray(array1);
      
      // linearSearch test
      System.out.println("\nLinear search for 30: " + javaSearch.linearSearch(array1, 30));
      System.out.println("Linear search for 86: " + javaSearch.linearSearch(array1, 86));
      System.out.println("Linear search for 87: " + javaSearch.linearSearch(array1, 87));
      System.out.println("Linear search for Array1[0]: " + javaSearch.linearSearch(array1, array1[0]));
      System.out.println("Linear search for Array1[49]: " + javaSearch.linearSearch(array1, array1[array1.length - 1]));
      
      // selectionSort test
      System.out.println("\nAfter sorting with selection sort:\n");
      javaSearch.selectionSort(array1);
      
      // binarySearch test
      System.out.println("\nBinary search for 11: " + javaSearch.binarySearch(array1, 11));
      System.out.println("Binary search for 28: " + javaSearch.binarySearch(array1, 28));
      System.out.println("Binary search for 74: " + javaSearch.binarySearch(array1, 74));
      System.out.println("Binary search for 100: " + javaSearch.binarySearch(array1, 100));
      System.out.println("Binary search for Array1[1]: " + javaSearch.binarySearch(array1, array1[0]));
      System.out.println("Binary search for Array1[49]: " + javaSearch.binarySearch(array1, array1[array1.length - 1]));
      
      // make array2
      int[] array2 = new int[100];
      for(i = 0; i < array2.length; ++i) 
      {
         array2[i] = (int)((Math.random() * 1000) + 1);
      } // end for
      
      // insertionSort test
      System.out.println("\nArray2 - unsorted\n");
      javaSearch.printIntArray(array2);
      System.out.println("\nAfter sorting with Insertion Sort:\n");
      javaSearch.insertionSort(array2);
      
   } // end main   
} // end class