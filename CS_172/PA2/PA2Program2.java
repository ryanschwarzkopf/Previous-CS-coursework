// PA2Program2.java
// Ryan Schwarzkopf
// CS 172 - 2
// 05/27/2022

import java.util.Scanner;

public class PA2Program2 {

   public static void main(String[] args){
      
      Scanner scnr = new Scanner(System.in);
      
      // input variable: sphereRadius
      // output variable: sphereVolume
      // calculation variable: pi
      double sphereRadius = 0.0;
      double sphereVolume = 0.0;
      double pi           = Math.PI;
      System.out.println(pi);
      // get radius from user
      System.out.println("Enter a radius of a sphere: ");
      
      // volume = 4/3 pi r^3
      sphereVolume = (4.0 / 3.0) * pi * Math.pow(sphereRadius, 3);
      
      // give volume to the user
      System.out.println("The volume of the sphere is: " + sphereVolume);
   
   } // end main

} // end class