import edu.colorado.concurrent.Amplifier;
public class AmplifierTest
{
   public static void main(String[ ] args)
   {
      int size = new Integer(args[0]);         // Size of the array to amplify
      int manyThreads = new Integer(args[1]);  // How many threads
      int manyTests = new Integer(args[2]);    // Number of tests
      int testNumber;                          // Test number
      double[] data = new double[size];        // The array itself
      int i;                                   // Array index
      double value = 42;                       // Value in data[42]
    
      long t0, t1;

      // Fill each data[i] with i
      for (i = 0; i < size; i++)
      {
	  data[i] = i;
      }

      t0 = System.currentTimeMillis( );
      for (testNumber = 0; testNumber < manyTests; testNumber++)
      {
          if (manyThreads == 1 && (args[3].equals("false")))
	  {
              amplify(data, 0, size, 10.0);
          }
          else
	  {
              Amplifier.concurrentRun(data, 0, size, 10.0, manyThreads);
          }
          value *= 10.0;
          if (data[42] != value)
              System.out.println("ERROR");
      }
      t1 = System.currentTimeMillis( );
      System.out.println((t1 - t0)/1000.0);
   }

   public static void amplify(double data[], int fromIndex, int toIndex, double factor)
   {
      int i;

      for (i = fromIndex; i < toIndex; i++)
      {
          data[i] *= factor;
      }
   }

}
