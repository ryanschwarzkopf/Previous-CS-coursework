// File: CuckooClock.java from the package edu.colorado.simulations
// Complete documentation is available from the CuckooClock link in
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.simulations;

/******************************************************************************
* A <CODE>CuckooClock</CODE> is a <CODE>Clock</CODE> that cuckoos when the 
* minute is zero. The primary purpose of this class is to demonstrate how an
* extended class is implemented.
*
* <b>Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/simulations/CuckooClock.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/CuckooClock.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
*
* @see Clock
******************************************************************************/
public class CuckooClock extends Clock
{   
   /**
   * Check whether this <CODE>CuckooClock</CODE> is currently cuckooing.
   * @return
   *   If this <CODE>CuckooClock</CODE>'s current minute is zero, then the
   *   return value is <CODE>true</CODE>; otherwise the return value is 
   *   <CODE>false</CODE>.
   **/
   public boolean isCuckooing( )
   {
      return (getMinute( ) == 0);
   } 
}
           
