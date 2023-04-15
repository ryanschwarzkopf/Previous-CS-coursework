package lab7;
/*******************************************************************************************************
 * Palindrome takes a string and calculates if it is a word by word palindrome. It uses a stack
 * and a queue to test. A single quote is considered part of a word. Palindrome parses words by 
 * any of these characters [ !\"\\#$%&()*+,-./:;<=>?@\\[\\]^_`{|}~]+
 * 
 * @author rschw
 * @version Oct 22, 2022
 * @see LinkedQueue
 * @see LinkStack
*******************************************************************************************************/
public class Palindrome {
	
	/**
	 * Test if a string is a word by word palindrome.
	 * @param t: String to be tested
	 * @return true: t is a w/w palindrome
	 * @return false: t is not a w/w palindrome
	 */
	public static boolean PalindromeTest(String t) {
		if((t == null) || (t == "")) throw new IllegalArgumentException("String is empty.");
		LinkedQueue<String> q = new LinkedQueue<String>();
		LinkStack<String> s = new LinkStack<String>();
		
		// parse input
		String[] input = t.split("[ !\"\\#$%&()*+,-./:;<=>?@\\[\\]^_`{|}~]+");
			
		// add to queue and stack
		for(String a : input) {
			q.enqueue(a.toLowerCase());
			s.push(a.toLowerCase());
		}
		
		// check for equality
		while(!q.isEmpty()) {
			if(q.dequeue().compareTo(s.pop()) != 0) return false;
		}
		return true;
	}
	
	/**
	 * Main method to test cases of PalindromeTest
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(PalindromeTest("This is a false test."));
		System.out.println(PalindromeTest("This is a true test test true a is this."));
		System.out.println(PalindromeTest("This is a true test true a is this."));
		System.out.println(PalindromeTest("Hello, from. The outside' The from Hello"));
		System.out.println(PalindromeTest("You can cage a swallow, can't you, but, you can't swallow a cage, can you?"));
		//System.out.println(PalindromeTest(""));
	}
}
