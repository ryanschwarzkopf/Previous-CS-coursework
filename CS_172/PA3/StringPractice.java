// CS 172 
// StringPractice.java 
// PA 3 
// Written by: Ryan Schwarzkopf 
// 06/03/2022 
// Practice using String methods

import java.util.Scanner;

public class StringPractice {

   public static void main(String[] args) {
   
      Scanner scnr = new Scanner(System.in);
      
      // 1)
      System.out.println("Enter a quote: ");
      String myString = scnr.nextLine();
      
      // 2)
      System.out.println("The length of the string is " + myString.length());
      
      // 3)
      String upperString = myString.toUpperCase();
      
      // 4)
      String lowerString = myString.toLowerCase();
      
      // 5)
      int xPosition = myString.indexOf("x");
      
      // 6)
      System.out.println("Enter your full name: ");
      String anotherString = scnr.nextLine();
      
      // 7)
      String noMs = anotherString.replace('M', 'N');
      
      // 8)
      int lastSpacePosition = anotherString.lastIndexOf(" ");
      
      // 9)
      String lastWord = anotherString.substring((lastSpacePosition + 1), (anotherString.length()));
      
      // 10)
      System.out.println("Your quote to upper case is: " + upperString);
      System.out.println("Your quote to lower case is: " + lowerString);
      System.out.println("The index of the first x in your quote is: " + xPosition);
      System.out.println("Changing all of the M's in your full name to Ns: " + noMs);
      System.out.println("The index of the last space in your full name: " + lastSpacePosition);
      System.out.println("Your last name is: " + lastWord);
   
   } // end main

} // end class