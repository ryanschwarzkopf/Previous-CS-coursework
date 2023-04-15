package lab8;
/*********************************************************************************
 * RecursiveQuestion is a compilation of methods. Each method is solved
 * recursively. This class contains one inner class Towers. Towers is a
 * data structure used for HanoiTower.
 * 
 * @author rschw
 * @version Oct 26, 2022
 *  
*********************************************************************************/
public class RecursiveQuestion {
	
	/**
	 * Towers has 3 towers each of length n. Rings are placed on towers from
	 * the bottom up. Only the top ring can be taken from a tower. A ring can
	 * only be placed on top of a ring with a larger diameter. The top
	 * instance variables hold the place of the top ring in a tower. If the
	 * tower is empty, the top is set to null. If the tower A has 1 ring,
	 * topA is set to 0. Rings are placed in a tower array from left to right.
	 * The empty spots in the array are set to 0. A ring can not have the value
	 * 0.
	 * 
	 * @author rschw
	 *
	 */
	public static class Towers {
		
		private int[] a;
		private int[] b;
		private int[] c;
		private Integer topA;
		private Integer topB;
		private Integer topC;
		
		/**
		 * Contruct towers with n rings on first peg and no rings on the other pegs
		 * Rings are sorted from 1 in on the top to n inches on the bottom. N
		 * must be less than 64 and greater than 0
		 * 
		 * @param n: 1 <= n <= 64
		 */
		Towers(int n) {
			if(n < 1 || n > 64) throw new IllegalArgumentException("Invalid n: 1 <= n <= 64");
			a = new int[n];
			b = new int[n];
			c = new int[n];
			
			for(int i = 0; i < a.length; i++) {
				a[i] = n - i;
			}
			topA = a.length - 1;
			topB = null;
			topC = null;
		}
		
		/**
		 * Get number of rings on a peg
		 * 
		 * @param pegNumbers(1, 2, 3)
		 * @return number of rings on a peg
		 */
		public int countRings(int pegNumbers) {
			if(!validPeg(pegNumbers)) throw new IllegalArgumentException("Illegal Peg");
			switch(pegNumbers) {
			case 1:
				if(topA == null) return 0;
				return topA + 1;
			case 2:
				if(topB == null) return 0;
				return topB + 1;
			case 3:
				if(topC == null) return 0;
				return topC + 1;
			}
			System.out.print("There was a problem");
			return -1;
		}
		
		/**
		 * Get the diameter of the top ring
		 * 
		 * @param pegnumber (1, 2, 3)
		 * @return Diameter of the top ring. If tower is empty: 0
		 */
		public int getTopDiameter(int pegnumber) {
			if(!validPeg(pegnumber)) throw new IllegalArgumentException("Illegal Peg");
			switch(pegnumber) {
			case 1:
				if(topA == null) return 0;
				return a[topA];
			case 2:
				if(topB == null) return 0;
				return b[topB];
			case 3:
				if(topC == null) return 0;
				return c[topC];
			}
			System.out.print("There was a problem");
			return -1;
		}
		
		/**
		 * Move ring from one tower to another
		 * 
		 * @param startPeg (1, 2, 3): there is a ring on the chosen startPeg
		 * @param endPeg (1, 2, 3): top ring from startPeg is smaller than top ring on endPeg
		 * @postcondition valid move: top ring from startpeg has been removed and is now top ring on endPeg
		 * @postcondition invalid move: no changes have occurred
		 */
		void move(int startPeg, int endPeg) {
			if(!validPeg(startPeg) || !validPeg(endPeg)) throw new IllegalArgumentException("Illegal Peg");
			if(getTopDiameter(startPeg) != 0 && (getTopDiameter(startPeg) < getTopDiameter(endPeg) || getTopDiameter(endPeg) == 0)) {
				// set top ring to endPeg
				switch(endPeg) {
				case 1:
					if(getTopDiameter(endPeg) == 0) {
						topA = 0;
					} else {
						topA++;
					}
					a[topA] = getTopDiameter(startPeg);
					break;
				case 2:
					if(getTopDiameter(endPeg) == 0) {
						topB = 0;
					} else {
						topB++;
					}
					b[topB] = getTopDiameter(startPeg);
					break;
				case 3:
					if(getTopDiameter(endPeg) == 0) {
						topC = 0;
					} else {
						topC++;
					}
					c[topC] = getTopDiameter(startPeg);
					break;
				}
				// take of top peg from start
				switch(startPeg) {
				case 1:
					a[topA] = 0;
					topA--;
					if(topA == -1) topA = null;
					break;
				case 2:
					b[topB] = 0;
					topB--;
					if(topB == -1) topB = null;
					break;
				case 3:
					c[topC] = 0;
					topC--;
					if(topC == -1) topC = null;
					break;
				} // end switch
			}// end if	
		} // end move
		
		/**
		 * Check if peg is valid.
		 * Private method for checking parameters
		 * 
		 * @param i
		 * @return true: valid
		 * @return false: invalid
		 */
		private static boolean validPeg(int i) {
			if(i == 1 || i == 2 || i == 3) return true;
			return false;
		} // end validPeg
		
		/**
		 * toString returns a string representation of the 3 towers
		 * @return string representation of 3 towers
		 */
		public String toString() {
			String answer = "";
			for(int i = a.length - 1; i >= 0; i--) {
				if(a[i] == 0) {
					answer += "| ";
				} else {
					answer += a[i] + " ";
				}
				if(b[i] == 0) {
					answer += "| ";
				} else {
					answer += b[i] + " ";
				}
				if(c[i] == 0) {
					answer += "| ";
				} else {
					answer += c[i] + " ";
				}
				answer += "\n";
			}
			return answer;
		}
		
	} // end class Towers
	
	
	/**
	 * Get the integer representation of a decimal string
	 * 
	 * @param s: String to be converted to integer
	 * @return integer decimal representation of string
	 * @precondition all characters in string must be a number
	 */
	public static int convert(String s) {
		if((s == null) || (s == "")) throw new IllegalArgumentException("String is empty or null");
		// base case
		if(s.length() == 1) return (s.charAt(0) - '0');
		// append the last character to the answer and then convert for the next substring and multiply is by 10
		// "1234" = (4 + (10 * (3 + (10 * (2 + (10 * (1)))))
		return (s.charAt(s.length()-1) - '0') + (10 * convert(s.substring(0, s.length() - 1)));
	}
	
	/**
	 * Get the Kth fibonacci number
	 * 
	 * @param k
	 * @precondition k > 0
	 * @return kth fibonacci number
	 */
	public static int FibBinaryRecursive(int k) {
		// base case
		if(k<2) {
			if(k<0) throw new IllegalArgumentException("k is less than 0");
			return k;
		}
		// calculate previous Fibonaccis then add them
		// 5 = (fib4 + fib3) = ((fib3 + fib2) + (fib2 + fib1)) = (((fib2 + fib1) + fib2) + (fib2 + fib1))
		//   = ((((fib1 + fib1) + fib1) + (fib1 + fib1)) + ((fib1 + fib1) + fib1)) = 8
		else {
			return FibBinaryRecursive(k - 1) + FibBinaryRecursive(k - 2);
		}
	}
	
	/**
	 * Hanoi solves the Hanoi tower problem. Precondition is left to be
	 * checked by the user for this method.
	 * 
	 * @param t: Towers object to be used.
	 * @param n: number of rings on first tower.
	 * @param start: tower begins with all rings, finishes empty
	 * @param target: begins empty, finishes with all rings
	 * @param spare: begins empty, finishes empty
	 * @precondition t should have n number of rings in start, 0 rings in target, and 0 rings in spare
	 */
	public static void HanoiTower(Towers t, int n, int start, int target, int spare) {
		if(n > 0) {
			HanoiTower(t, n-1, start, spare, target);
			t.move(start, target);
			System.out.println(t.toString());
			HanoiTower(t, n-1, spare, target, start);
		}
	}
	
	/**
	 * Print permutations of a set. To print all permutations,
	 * To permutate all elements, set prefix = 0
	 * @param a: array to permutate
	 * @param prefix
	 * @precondition The set should not be null and the prefix should be less than the sets length
	 */
	public static void Permutation(int[] a, int prefix) {
		if(a == null) throw new IllegalArgumentException("a is null");
		if(prefix >= a.length) throw new IllegalArgumentException("Prefix must be less than a.length");
		if(a.length-1 == prefix) {
			for(int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}else {
			for(int i = prefix; i < a.length; i++) {
				// swap
				int temp = a[prefix];
				a[prefix] = a[i];
				a[i] = temp;
				// recursion for next prefix
				Permutation(a, prefix+1);
				// swap back
				a[i] = a[prefix];
				a[prefix] = temp;
			}
		}
		
	}
	
	/**
	 * Reverses order of elements of array from element x to element y inclusive. 
	 * 
	 * @param a: array to be swapped
	 * @param x: first element to be swapped (Element 1 is a[0]. Element 0 is invalid.)
	 * @param y: last element to be swapped (y < )
	 * @precondition a.length > X > 0
	 * @precondition a.length > Y > 0
	 * @precondition X >= Y returns original array 
	 * @return swapped array
	 */
	public static int[] ArraySwap(int[] a, int x, int y) {
		if(x <= 0 || x > a.length) throw new IllegalArgumentException("X is out of range");
		if(y <= 0 || y > a.length) throw new IllegalArgumentException("Y is out of range");
		
		// return case
		if(x >= y) {
			return a;
		}
		// swap
		int temp = a[x-1];
		a[x-1] = a[y-1];
		a[y-1] = temp;
		// recursion for inside elements
		return ArraySwap(a, x+1, y-1);
	}
	
	
	
	/**
	 * Compute x^n
	 * This method is O(log(n)). Worst case is a negative, odd value of n. Which will
	 * take two more calls before it gets to an even n value.
	 * 
	 * @param x
	 * @param n
	 * @precondition if X is zero, N must be positive 
	 * @return x^n
	 */
	public static double pow(double x, int n) {
		if((n == 0) && (x <= 0)) throw new IllegalArgumentException("NAN");
		
		if(n == 0) {
			return 1;
		} else if (x == 0) {
			return 0;
		} else if(n % 2 == 0){
			double a = pow(x, n/2);
			return a * a;
		} else if(n > 0) {
			return x * pow(x, n-1);
		} else { // x is nonzero, and n is negative
			return 1/pow(x, -n);
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println("Convert: " + convert("58895") + "\n");
		System.out.println("FibBinaryRecursive: " + FibBinaryRecursive(6) + "\n");
		System.out.println("Permutation: ");
		int[] a = {1, 2, 3, 4};
		Permutation(a, 0);
		System.out.println();
		System.out.print("ArraySwap: ");
		a = ArraySwap(a, 2, 4);
		for(int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.print("Pow: ");
		System.out.println(pow(2, 4) + "\n");
		RecursiveQuestion.Towers myTower = new RecursiveQuestion.Towers(5);
		System.out.println("Tower class check: ");
		System.out.println(myTower.toString());
		myTower.move(1, 2);
		myTower.move(1, 2);
		myTower.move(1, 2);
		myTower.move(1, 2);
		myTower.move(1, 2);
		myTower.move(1, 2);
		myTower.move(1, 2);
		System.out.println(myTower.toString());
		System.out.println(myTower.countRings(1));
		System.out.println(myTower.countRings(2));
		System.out.println(myTower.countRings(3));
		RecursiveQuestion.Towers newTower = new RecursiveQuestion.Towers(5);
		System.out.println();
		System.out.println("HanoiTower: ");
		HanoiTower(newTower, 5, 1, 2, 3);
	}
}
