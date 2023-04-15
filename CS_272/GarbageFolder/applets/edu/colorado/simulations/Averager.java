// File: Averager.java from the package edu.colorado.simulations
// Additional javadoc documentation is available from the Averager link at
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.simulations;

/******************************************************************************
* An <CODE>Averager</CODE> computes an average of a group of numbers.
*
* <b>Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/simulations/Averager.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/Averager.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Averager
{
   private int count;  // How many numbers have been given to this averager
   private double sum; // Sum of all the numbers given to this averager
                      
   /**
   * Initialize an <CODE>Averager</CODE>.
   * param - none
   * <b>Postcondition:</b>
   *   This <CODE>Averager</CODE> has been initialized and is ready to accept numbers.
   **/
   public Averager( )
   {
       count =0;
       sum = 0;
   }


   /**
   * Give another number to this <CODE>Averager</CODE>.
   * @param value
   *   the next number to give to this <CODE>Averager</CODE>
   * <b>Precondition:</b>
   *   <CODE>howManyNumbers() &lt; Integer.MAX_VALUE</CODE>.
   * <b>Postcondition:</b>
   *   This <CODE>Averager</CODE> has accepted <CODE>value</CODE> as the next number.
   * @exception IllegalStateException
   *   Indicates that <CODE>howManyNumbers()</CODE> is 
   *   <CODE>Integer.MAX_VALUE</CODE>.
   **/   
   public void addNumber(double value)
   {
      if (count == Integer.MAX_VALUE)
         throw new IllegalStateException("Too many numbers");
      count++;
      sum += value;
   }
 

   /**
   * Provide an average of all numbers given to this <CODE>Averager</CODE>.
   * @return
   *   the average of all the numbers that have been given to this
   *   <CODE>Averager</CODE>
   *   the next number to give to this <CODE>Averager</CODE>
   * <b>Postcondition:</b>
   *   If <CODE>howManyNumbers()</CODE> is zero, then the answer is
   *   <CODE>Double.NaN</CODE> ("not a number"). The answer may also be
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE> if there has been an arithmetic
   *   overflow during the summing of all the numbers.
   **/
   public double average( )
   {
      if (count == 0)
         return Double.NaN;
      else
         return sum/count;
   } 


   /**
   * Provide a count of how many numbers have been given to this <CODE>Averager</CODE>.
   * @return
   *   the count of how many numbers have been given to this <CODE>Averager</CODE>
   **/
   public int howManyNumbers( )
   {
      return count;
   }
}
