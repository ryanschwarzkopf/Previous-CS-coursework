// File: Clock24.java from the package edu.colorado.simulations
// Complete documentation is available from the Clock24 link in
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.simulations;

/******************************************************************************
* A <CODE>Clock24</CODE> is a <CODE>Clock</CODE> that provides its hour in 
* 24-hour format (0 to 23) instead of 12-hour format. The purpose is to show
* how an extended class may override a method of the superclass.
*
* <b>Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/simulations/Clock24.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/Clock24.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
*
* @see Clock
******************************************************************************/
public class Clock24 extends Clock
{   
   /**
   * Get the current hour of this <CODE>Clock24</CODE>, in 24-hour format.
   * @return
   *   the current hour (always in the range 0...23)
   **/
   public int getHour( )
   {       
      int ordinaryHour = super.getHour( );

      if (isMorning( ))
      {
         if (ordinaryHour == 12)
            return 0;
         else
            return ordinaryHour;
      }
      else
      {
         if (ordinaryHour == 12)
            return 12;
         else
            return ordinaryHour + 12;
      }
   }
}
           
