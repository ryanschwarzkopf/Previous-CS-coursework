// File: AssertExamples.java
// A Java application to demonstrate the Java assert statement.
//
// Compilation note: With the Java 2 Version 1.4 compiler from the SDK, the
// compilation must include -source 1.4, as shown here:
//   javac -source 1.4 AssertExamples.java
//
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/AssertExamples.html

/******************************************************************************
* The AssertExamples Java application demonstrates the Java
* assert statement.
*
* @see <A HREF="../applications/AssertExamples.java">
*      Java Source Code
*      (www.cs.colorado.edu/~main/applications/TemperatureConversion.java)
*      </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class AssertExamples
{

   /**
   * The main method demonstrates calls to maxOf3
   * and maxOfArray .
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args) 
   {
      int[ ] array = { 10, 20, 30, -40 };
	
      System.out.println("Max of 3 (should be 22): " + maxOf3(10, 2, 22));
      System.out.println("Max of array (should be 30): " + maxOfArray(array));
   }

   // This private method returns true if the specified value appears somewhere
   // in the array a; otherwise the return value is false.  
   static boolean contains(int a[], int value)
   {
      for (int item : a)
      {
         if (item == value)
       	    return true;
      }
      return false;
   }
        
   // This private method returns true if the specified value is greater than
   // or equal to every element in the array a; otherwise the return value is
   // false.  
   static boolean greaterOrEqual(int a[], int value)
   {
      for (int item : a)
      {
         if (item > value)
       	    return false;
      }
      return true;
   }
        
   /**
   * Returns the largest of three int values.
   * @param a
   *   any int value
   * @param b
   *   any int value
   * @param c
   *   any int value
   * @return
   *   The return value is the largest of the three arguments a, b and c.
   * @example
   *   maxOf3(2, -8, 1); // Returns 2
   **/  
   public static int maxOf3(final int a, final int b, final int c)
   {
	       
      int answer; 

      answer = a;

      // Change answer to b if b is bigger:
      if (b > answer)
	 answer = b;

      // Change answer to c if b is bigger:
      if (c > answer)
	 answer = c;

      assert (answer == a) || (answer == b) || (answer == c)
	   : "maxOf3 answer is not equal to one of the arguments";
      assert (answer >= a) && (answer >= b) && (answer >= c)
	   : "maxOf3 answer is not equal to the largest argument";
      return answer;
   }

   /**
   * Returns the largest value in an array
   * @param a
   *   an array of int values
   * @precondition
   *   a.length &gt; 0
   * @throws java.lang.ArrayIndexOutOfBoundsException
   *   Indicates that a.length &lt;= 0.
   * @return
   *   The return value is the largest value in a.
   **/  
   public static int maxOfArray(final int a[ ])
   {
      int answer; // The answer will be stored here.
      int i;      // Array index
      
      answer = a[0];
      for (i = 1; i < a.length; i++)
      {
         if (a[i] > answer)
	    answer = a[i];
      }
      
      assert contains(a, answer)
	   : "maxOfArray answer is not in the array";
      assert greaterOrEqual(a, answer)
	   : "maxOfArray answer is less than an element of the array";
      return answer;
   }
         
}
