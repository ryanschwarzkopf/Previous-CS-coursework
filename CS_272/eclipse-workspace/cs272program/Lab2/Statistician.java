package Lab2;

/**
 * Statistician saves calculates from a sequence of numbers: length, last, smallest, largest, sum, and mean
 * Numbers in the sequence are not saved
 * 
 * @author rschw
 *
 */

public class Statistician {

   private int length = 0;
   private double last = Double.NaN;
   private double smallest = Double.NaN;
   private double largest = Double.NaN;
   private double sum = Double.NaN;
   private double mean = Double.NaN;

   /**
    * Calculates length, last, smallest, largest, sum, and mean of sequence including num.
    * @param num number to add to sequence
    */
   public void nextNumber(double num) {
	   ++length;
	   last = num;
	   if(Double.isNaN(smallest)) { // check if this is first call of nextNumber(private variables are set to Double.NaN)
    	  smallest = num;
    	  largest = num;
    	  sum = num;
    	  mean = num;
      } else {
    	  if(num < smallest) {
    		  smallest = num;
    	  }
    	  if(num > largest) {
    	      largest = num;
    	  } 
    	  sum += num;
    	  mean = sum / length;
      } // end else      
   } // end nextNumber
   
   /**
    * Get the number of numbers added to this Statistician.
    * @return length of sequence in this Statistician
    */
   public int length() {
      return length;
   }
   
   /**
    * Get the last number added to this Statistician.
    * @return last number added to this Statistician.
    */
   public double last() {
      return last;
   }

   /**
    * Get the smallest number entered to this Statistician.
    * @return smallest number entered to this Statistician.
    */
   public double smallest() {
      return smallest;
   }
   
   /**
    * Get the largest number entered into this Statistician.
    * @return largest number entered into this Statistician
    */
   public double largest() {
      return largest;
   }

   /**
    * Get the sum of all numbers entered into this Statistician.
    * @return sum of all numbers entered into this Statistician.
    */
   public double sum() {
      return sum;
   }

   /**
    * Get the mean of all numbers entered into this Statistician.
    * @return mean of all numbers entered into this Statistician.
    */
   public double mean() {
      return mean;
   }

   /**
    * Add two Statistician objects
    * 
    * @param stat1 (this objects instance variables can not have the value Double.NaN).
    * @param stat2 (this objects instance variables can not have the value Double.NaN).
    * @return Statistician object 
    * @throws IllegalArgumentException(Checks for Double.NaN)
    */
   public static Statistician combine(Statistician stat1, Statistician stat2) throws IllegalArgumentException {
	  if(Double.isNaN(stat1.last) || Double.isNaN(stat2.last)) {
		  throw new IllegalArgumentException("Statistician does not have any values.");
	  }
	  Statistician answer = new Statistician();
      answer.length = stat1.length + stat2.length;
      answer.last = stat2.last;
      if(stat1.smallest < stat2.smallest) {
         answer.smallest = stat1.smallest;
      }
      else {
         answer.smallest = stat2.smallest;
      }
      if(stat1.largest > stat2.largest) {
         answer.largest = stat1.largest;
      }
      else {
         answer.largest = stat2.largest;
      }
      answer.sum = stat1.sum + stat2.sum;
      answer.mean = ((stat1.mean + stat2.mean) / 2);
      return answer;
   } // end combine
   
   /**
    * Generate a string representation of this Statistician.
    * @return string representation of this Statistician.
    */
   public String toString() {
	   return "length=" + length + " last=" + last
			   + " smallest=" + smallest + " largest=" + largest
			   + " sum=" + sum + " mean=" + mean;
   } // end toString

} // end class Statistician