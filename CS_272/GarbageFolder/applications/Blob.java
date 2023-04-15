// FILE: Blob.java
//  This small demonstration shows how the Organism class is used.

import edu.colorado.simulations.Organism;

public class Blob
{                                                                                   
   public static void main(String[ ] args)
   {
      Organism blob = new Organism(20.0, 100000.0);
      int week;

      // Untroubled by conscience or intellect, the Blob grows for three weeks.
      for (week = 1; week <= 3; week++)
      {
         blob.simulateWeek( );
         System.out.print("Week " + week + ":" + " the Blob is ");
         System.out.println(blob.getSize( ) + " ounces.");
      }

      // Steve McQueen reverses the growth rate to -80000 ounces per week.
      blob.setRate(-80000.0);
      while (blob.isAlive( ))
      {
         blob.simulateWeek( );
         System.out.print("Week " + week + ":" + " The Blob is ");
         System.out.println(blob.getSize( ) + " ounces.");
         week++;
      }
      System.out.println("The Blob (or its son) shall return.");
   }

}  
