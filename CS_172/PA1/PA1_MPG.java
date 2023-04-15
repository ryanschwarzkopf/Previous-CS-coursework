//PA1_MPG
//Ryan Schwarzkopf
//CS 172 - 1
//05/25/2022

import java.util.Scanner; 
public class PA1_MPG { 
   public static void main (String args[]) { 
      Scanner scnr = new Scanner(System.in); 
      float gallonsUsed; 
      float milesDriven; 
      float milesPerGallon; 
 
      // input number of miles driven 
      System.out.println("Enter the number of miles driven"); 
      milesDriven = scnr.nextFloat(); 
 
      // input number of gallons used 
      System.out.println("Enter the number of gallons used"); 
      gallonsUsed = scnr.nextFloat(); 
 
      // calculate miles per gallon 
      milesPerGallon = milesDriven / gallonsUsed; 
 
      // display the miles per gallon 
      System.out.printf("Miles Driven     %8.2f\n", milesDriven); 
      System.out.printf("Gallons Used     %8.2f\n", gallonsUsed); 
      System.out.printf("-------------------------\n"); 
      System.out.printf("Miles Per Gallon %8.2f\n", milesPerGallon); 
   } // end main 
} // end class