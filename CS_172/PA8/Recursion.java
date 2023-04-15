// CS 172 
// Recursion.java 
// PA 8
// Written by: Ryan Schwarzkopf 
// 06/21/2022 
// Recursion Practice

public class Recursion {


   public static void printLettersForward(char c) {
      char find = Character.toLowerCase(c);
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      int i;
      int letter = alphabet.indexOf(find);
      
      // base case
      if(!(Character.isLetter(c))) {
         return;
      } // end if
      else if(letter == 0) {
      } // end if
      
      else {
         printLettersForward(alphabet.charAt(letter - 1));
      } // end else
      
      System.out.print(" " + alphabet.charAt(letter));
   } // end printLettersForward
   
   
   public static double powerOfTen(int a) {
      double result = 0;
      
      // base case
      if(a == 1) {
         return 10;
      } // end if
      else if(a == 0) {
         return 1;
      } // end if
      
      else if(a > 1) {
         result = 10 * powerOfTen(a - 1);
      } // end if
      else if(a < 0) {
         result = powerOfTen(a + 1) / 10;
      } // end if
      
      return result;
   } // end powerOfTen
   
   
   public static void stringByWords(String s) {
      int i = 0;
      boolean leave = false;
      while(i < s.length()) {
         if(s.length() == 0) {
            break;
         } // end if
         else if(s.charAt(i) == ' ') {
            System.out.println();
            stringByWords(s.substring(i + 1));
            leave = true;
         } // end if
         else{
            System.out.print(s.charAt(i));
         } // end else
         if(leave){
            break;
         } // end if
         ++i;
      } // end while
   } // end stringByWords
   
      
   public static void main(String[] args) {
      // test printLettersForward method
      printLettersForward('z');
      System.out.println();
      printLettersForward('!');
      System.out.println();
      printLettersForward('a');
      System.out.println();
      printLettersForward('o');
      
      // test powerOfTen method
      System.out.println("\n\n" + powerOfTen(-3));
      System.out.println("\n" + powerOfTen(4));
      System.out.println("\n" + powerOfTen(0));
      System.out.println("\n" + powerOfTen(1));
      
      // test stringByWords method
      System.out.println();
      stringByWords("Hello from across the way");
      System.out.println("\n");
      stringByWords("Hello");
      System.out.println("\n");
      stringByWords("123456 78");
   } // end main


} // end class