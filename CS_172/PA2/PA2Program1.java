// PA2Program1.java
// Ryan Schwarzkopf
// CS 172 - 2
// 05/27/2022

import java.util.Scanner;

public class PA2Program1 {

   public static void main(String[] args){
   
      Scanner scnr = new Scanner(System.in);
      
      // input variable: totalSeconds
      // output variables: numHours, numMinutes, numSeconds
      // remainingSeconds, secondsPerHour, and secondsPerMinute are used for calculation
      int totalSeconds           = 0;
      int numHours               = 0;
      int numMinutes             = 0;
      int numSeconds             = 0;
      int remainingSeconds       = 0;
      final int secondsPerHour   = 3600;
      final int secondsPerMinute = 60;
      
      // Collect total number of seconds from the user
      System.out.println("Enter the number of seconds: ");
      totalSeconds = scnr.nextInt();
      
      // Calculate the number of hours in total seconds and the remainder of seconds
      // by dividing total seconds by the conversion variable and then remainding it too 
      // Repeat for minutes and seconds
      numHours         = totalSeconds / secondsPerHour;
      remainingSeconds = totalSeconds % secondsPerHour;
      numMinutes       = remainingSeconds / secondsPerMinute;
      numSeconds       = remainingSeconds % secondsPerMinute;
      
      // give results to the user 
      System.out.println(numHours + " hours, " + numMinutes + " minutes, and " + numSeconds + " seconds");
   
   } // end main
   
} // end class