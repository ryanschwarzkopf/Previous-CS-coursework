// CS 172 
// PA6Test.java 
// PA 6
// Written by: Ryan Schwarzkopf 
// 06/15/2022 
// Practice making methods

import java.util.Arrays;

public class PA6Test {

   public static void main(String[] args) {
      
      // PA6Methods.printOddNumbers
      System.out.println("From printOddNumbers:\n");
      PA6Methods.printOddNumbers(100);
      
      // PA6Methods.countNumbers
      int[] array1 = {12, 13, 1, 25, 1, 1, 2, 3, 4};
      System.out.println("\nFrom method countNumbers with array {12, 13, 1, 25, 1, 1, 2, 3, 4}:\n"
                         + PA6Methods.countNumbers(array1, 1));
      int[] array2 = new int[15];
      array2[4] = 12;
      array2[8] = 12;
      System.out.println("\nFrom method countNumbers with a null array of 15 except index 4 = 12 and index 8 = 12:\n"
                         + PA6Methods.countNumbers(array2, 12));
      // PA6Methods.phoneNumber
      String String1 = "5097728686";
      System.out.println("\nFrom method phoneNumber with string 5097728686:\n" + PA6Methods.phoneNumber(String1));
      String String2 = "20322970";
      System.out.println("\nFrom method phoneNumber with string 20322970:\n" + PA6Methods.phoneNumber(String2)); // invalid test
      String String3 = "505-20ab";
      System.out.println("\nFrom method phoneNumber with phone string 505-20ab:\n" + PA6Methods.phoneNumber(String3)); // invalid test
     
      // PA6Methods.gradeTable
      float[] grades1 = {100.0f, 31.5f, 51.6f, 77.9f, 88.0f, 90.0f, 61.1f};
      System.out.println("\nFrom method gradeTable with array of grades: 100.0f, 31.5f, 51.6f, 77.9f, 88.0f, 90.0f, 61.1f:\n" + Arrays.toString(PA6Methods.gradeTable(grades1)));
      float[] grades2 = new float[15];
      grades2[0] = -1.22f;
      System.out.println("\nFrom method gradeTable with empty array of 15, and the first index has a grade of -1.22:\n" + Arrays.toString(PA6Methods.gradeTable(grades2))); // invalid test
      
   } // end main
} // end class