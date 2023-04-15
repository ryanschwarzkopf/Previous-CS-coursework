// CS 172 
// PA6Methods.java 
// PA 6 
// Written by: Ryan Schwarzkopf 
// 06/15/2022 
// Practice making methods


public class PA6Methods {

   public static void printOddNumbers( int max ) { 
    
      // prints the odd numbers less than or equal to max 
 
      int n = 1, count = 0; 
      while (n <= max) { 
         System.out.printf("%5d", n);   
         n = n + 2; 
         count++; 
         System.out.print( ( count % 10 == 0 ) ? "\n" : "" ); 
      } // end while 
   } // end printOddNumbers
   
   // countNumbers searches through a integer array for a number and returns the count
   public static int countNumbers(int[] data, int num) {
      int numCount = 0;
      int i;
      for(i = 0; i < data.length; ++i) {
         if(data[i] == num)
            ++numCount;
      } // end if
      return numCount;
   } // end countNumbers
   
   // phoneNumber checks for a valid input (length and only digits) then returns the phonenumber as a formattted string
   public static String phoneNumber(String phone) {
      boolean hasLetter = false;
      int i;
      char temp;
      for(i = 0; i < phone.length(); ++i) {
         if(!(Character.isDigit(phone.charAt(i)))) {
            hasLetter = true;
            break;
            } // end if
      } // end for
      
      if(phone.length() != 10 || hasLetter) {
         String error = "Invalid Phone Number";
         return error;
      } // end if
      else {
         String formatString = "(" + phone.charAt(0) + phone.charAt(1) + phone.charAt(2) + ") " + 
                               phone.charAt(3) + phone.charAt(4) + phone.charAt(5) + " " + 
                               phone.charAt(6) + phone.charAt(7) + phone.charAt(8) + phone.charAt(9);
         return formatString;
      } // end else        
   } // end phoneNumber
   
   // gradeTable takes an array of grades counts the number of each letter grade there is and returns the array
   public static int[] gradeTable(float[] scores) {
      int[] letterGrades = {0, 0, 0, 0, 0};
      int i;
      for(i = 0; i < scores.length; ++i) {
         if(scores[i] >= 90.0)
            letterGrades[0] += 1;
         else if(scores[i] >= 80.0)
            letterGrades[1] += 1;
         else if(scores[i] >= 70.0)
            letterGrades[2] += 1;
         else if(scores[i] >= 60.0)
            letterGrades[3] += 1;
         else if(scores[i] >= 0.0 && scores[i] < 60.0)
            letterGrades[4] += 1;
         else {
            System.out.print("Invalid score");
            break;
         } // end else
      } // end for
      return letterGrades;
   } // end gradeTable
   
   
} // end class