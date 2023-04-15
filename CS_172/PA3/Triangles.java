// CS 172 
// StringPractice.java 
// PA 3 
// Written by: Ryan Schwarzkopf 
// 06/03/2022 
// Practice using String methods

import java.util.Scanner;

public class Triangles {

   public static void main(String[] args) {
   
      float side1, side2, side3;
      double area;
      
      Scanner scan = new Scanner(System.in);
      
      for (int i = 1; i <= 5; i++) {
         
         // get side lengths from user
         System.out.println("Enter length for side 1: ");
         side1 = scan.nextFloat();
         System.out.println("Enter length for side 2: ");
         side2 = scan.nextFloat();
         System.out.println("Enter length for side 3: ");
         side3 = scan.nextFloat();
         
         // declare/initialize calculation variables
         String triangleType;
         float s = (side1 + side2 + side3) / 2; // s = half the perimeter
         area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Heron's formula
         
         if (((side1 + side2) > side3) && ((side2 + side3) > side1) && ((side1 + side3) > side2)) { //test for triangle (triangle inequality theorem)
            if ((Math.abs(side1 - side2) < 0.0001) && (Math.abs(side1 - side3) < 0.0001)) { // all sides are equal? (using float tests)
               triangleType = "equilateral";
            } // end if (equilateral = true)
            
            else if ((Math.abs(side1 - side2) > 0.0001) && (Math.abs(side2 - side3) > 0.0001) && (Math.abs(side1 - side3) > 0.0001)) { // all sides are different? (using float tests)
               triangleType = "scalene";
            } // end if (scalene = true)
            
            else { // else two sides must be the same
               triangleType = "isosceles";               
            } // end else (type)
            
            System.out.printf("The triangle is " + triangleType + "   The area is " + String.format("%.2f", area) + ".\n"); // printf to get format for only 2 decimal places
         } // end if (triangle = true)
         
         else {
            System.out.println("The 3 lengths cannot form a triangle.");
         } // end else (triangle)
         
         System.out.println("\n");         
      } // end for loop
   
   } // end main

} // end class