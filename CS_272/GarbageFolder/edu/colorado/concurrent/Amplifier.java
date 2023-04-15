// File: Amplifier.java
// Provides a method for searching an array of double numbers for a target.
// It's primary purpose is to introduce concurrent processing in Java.
// Additional javadoc documentation is available from the Amplifier link at:
//   http://www.cs.colorado.edu/~main/docs
package edu.colorado.concurrent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Vector;

/******************************************************************************
* The <CODE>Amplifier</CODE> class implements a method that can search an array
* of double numbers for a specified target. It's primary purpose is to 
* introduce concurrent processing in Java.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../edu/colorado/concurrent/Amplifier.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/concurrent/Amplifier.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 17, 2011
*******************************************************************************/
public class Amplifier implements Runnable
{
   // The run method of this class multiplies some of the elements of data by 
   // the a factor, and stores the results back into data. The elements
   // affected are data[loIndex] up to but not including data[hiIndex].
   double[] data;
   int loIndex, hiIndex;
   double factor;

   /**
   * Create an object that can search for a target within part of an array. 
   * <dt><b>Precondition:</b><dd>
   *   0 <= <CODE>firstIndex</CODE> <= <CODE>hiIndex</CODE> <= <CODE>data.length</CODE>
   * @param <CODE>data</CODE>
   *   the array to be searched
   * @param <CODE>loIndex</CODE> 
   *   the start index for the portion of the array that will be searched
   * @param <CODE>hiIndex</CODE>
   *   the index just beyond the end of the portion of the array to be searched
   * @param <CODE>target</CODE>
   *   the number to be searched for within part of the array
   * @exception NullPointerException
   *   Indicates illegal values of <CODE>loIndex</CODE> or <CODE>hiIndex</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates illegal values of <CODE>loIndex</CODE> or <CODE>hiIndex</CODE>.
   **/
   public Amplifier(double[] data, int loIndex, int hiIndex, double factor)
   {
      // Check that the indices are valid:
      if (0 > loIndex || loIndex > hiIndex || hiIndex > data.length)
         throw new ArrayIndexOutOfBoundsException("Illegal indices");

      // Copy the parameters to the instance variables:
      this.data = data;
      this.loIndex = loIndex;
      this.hiIndex = hiIndex;
      this.factor = factor;
 }

   /**
   * Do the work to increase the elements of the array by the factor.
   * <dt><b>Returns:</b><dd>
   *   If <CODE>factor</CODE> is within the part of the array from 
   *   <CODE>data[loIndex]</CODE> up to but not including
   *   <CODE>data[hiIndex]</CODE>, then the return value is some index i
   *   with <CODE>data[i] == factor</CODE>. Otherwise, this method
   *   throws an exception as described below.
   * @exception Exception
   *   Indicates that the <CODE>factor</CODE> is not present in the specified
   *   portion of the array.
   * <dt><b>Note:</b><dd>
   *   The reason for throwing an exception is to allow this method to
   *   more easily be used by an Executor in the <CODE>concurrentSearch</CODE>
   *   method.
   **/
   public void run( )
   {
      int i;

      for (i = loIndex; i < hiIndex; i++)
      {
	  data[i] *= factor;
      }
   }

   /**
   * Use Amplifier objects to concurrently search of part of an array for a factor.
   * <dt><b>Precondition:</b><dd>
   *   0 <= <CODE>firstIndex</CODE> <= <CODE>hiIndex</CODE> <= <CODE>data.length</CODE>
   *   and manyThreads > 0.
   * @param <CODE>data</CODE>
   *   the array to be searched
   * @param <CODE>loIndex</CODE> 
   *   the start index for the portion of the array that will be searched
   * @param <CODE>hiIndex</CODE>
   *   the index just beyond the end of the portion of the array to be searched
   * @param <CODE>factor</CODE>
   *   the number to be searched for within part of the array
   * @param <CODE>manyThreads</CODE>
   *   how many different Amplifier objects to use, each in a different thread
   * <dt><b>Returns:</b><dd>
   *   If <CODE>factor</CODE> is within the part of the array from 
   *   <CODE>data[loIndex]</CODE> up to but not including
   *   <CODE>data[hiIndex]</CODE>, then the return value is some index i
   *   with <CODE>data[i] == factor</CODE>. Otherwise, the return value is -1.
   * @exception IllegalArgumentException
   *   Indicates that manyThreads <= 0.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates illegal values of <CODE>loIndex</CODE> or <CODE>hiIndex</CODE>.
   **/
   public static boolean concurrentRun
   (double[] data, int loIndex, int hiIndex, double factor, int manyThreads)
   {
      // The executor runs the pieces concurrently:
      ExecutorService executor = Executors.newFixedThreadPool(manyThreads);

      int pieceSize = (hiIndex - loIndex)/manyThreads; // Size of most pieces
      int finalStart = loIndex + pieceSize*(manyThreads-1); // Start of last piece
      int start, end; // Indices for the start and end of one piece
      int i;          // Loop control variable
      final long LIMIT = 86400; // Limit on runtime of 86400 seconds

      // Validate the preconditions:
      if (manyThreads <= 0)
	 throw new IllegalArgumentException("manyThreads must be positive");
      if (0 > loIndex || loIndex > hiIndex || hiIndex > data.length)
         throw new ArrayIndexOutOfBoundsException("Illegal indices");

      // Submit all the threads except the final one (since it may be bigger):
      for (i = 0; i < manyThreads-1; i++)
      {   
          start = loIndex + pieceSize*i;
	  end = start + pieceSize;
          executor.submit(new Amplifier(data, start, end, factor));
      }
      // Add final thread, and let executor know there will be no more threads:
      executor.submit(new Amplifier(data, finalStart, hiIndex, factor));
      executor.shutdown( );

      try
      {   // Wait for the submitted threads to complete their work.
	  return executor.awaitTermination(LIMIT, TimeUnit.SECONDS);
      }
      catch (InterruptedException e)
      {  // Someone requested an early shutdown (see text for how we handle this):
         Thread.currentThread( ).interrupt( );
         return false;
      }
   }
}
