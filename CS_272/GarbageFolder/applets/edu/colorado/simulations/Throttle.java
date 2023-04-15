// File: Throttle.java from the package edu.colorado.simulations
// Additional javadoc documentation is available from the Throttle link in:
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.simulations;

/******************************************************************************
* A Throttle object simulates a throttle that is controlling 
* fuel flow.
*
* @see
*   <A HREF="../../../../edu/colorado/simulations/Throttle.java">
*   Java Source Code for this class
*   (www.cs.colorado.edu/~main/edu/colorado/simulations/Throttle.java)
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Throttle
{
   private int top;      // The topmost position of the throttle
   private int position; // The current position of the throttle
                      
   /**
   * Construct a Throttle with a specified number of 
   * "on positions."
   * @param size
   *   the number of "on positions" for this new Throttle
   * @precondition
   *   size &gt; 0
   * @postcondition
   *   This Throttle has been initialized with the specified
   *   number of "on positions" above the shutoff position, and it is
   *   currently shut off.
   * @exception IllegalArgumentException
   *   Indicates that size is not positive.
   **/
   public Throttle(int size)
   {
       if (size <= 0)
           throw new IllegalArgumentException("Size <= 0: " + size);
       top = size;
       position = 0;
       // No assignment needed for position -- it gets the default value of 0.
   }


   /**
   * Get the current flow of this Throttle.
   * @return
   *   the current flow rate (always in the range 
   *   [0.0 ... 1.0] ) as a proportion of the maximum flow
   **/
   public double getFlow( )
   {
      return (double)position / (double)top;
   }
   

   /**
   * Check whether this Throttle is on.
   * @return
   *   If this Throttle's flow is above zero, then the return
   *   value is true; otherwise the return value is false.
   **/
   public boolean isOn( )
   {
      return (position > 0);
   }

   
   /**
   * Move this Throttle's position up or down.
   * @param amount
   *   the amount to move the position up or down (a positive amount
   *   moves the position up, a negative amount moves it down)
   * @postcondition
   *   This Throttle's position has been moved by the specified
   *   amount. If the result is more than the topmost position, then the
   *   position stays at the topmost position. If the result is less than the
   *   zero position, then the position stays at the zero position.
   **/
   public void shift(int amount)
   {   
       if (amount > top - position)
          // Adding amount would put the position above the top.
          position = top;
       else if (position + amount < 0)
          // Adding amount would put the position below zero.
          position = 0;
       else
          // Adding amount puts position in the range [0...top].
          position += amount;                 
   }

   
   /**
   * Turn off this Throttle.
   * @postcondition
   *   This Throttle has been turned off.
   **/   
   public void shutoff( )
   {
       position = 0;
   }
   
   
}
