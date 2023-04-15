package lab7;
/******************************************************************************************************
 * NQueen has one public method that takes an integer N. NQueen calculates if it is possible to
 * place N number of queens on an NxN size chess board. If it is possible it returns a
 * string representation of the the valid queen placement. If it is not possible it returns
 * "false".
 * 
 * @note Time complexity for NQueens is O(N^N) and is not recommended for large values of N
 * @author rschw
 * @version Oct 22, 2022
 * @see LinkStack
*****************************************************************************************************/
public class NQueen implements Cloneable{
	
	/**
	 * Calculate if you can place N number of queens on a NxN grid
	 * without any queen attacking another queen. 
	 * @param N: number of queens, and size of grid is NxN
	 * @return valid: String representation of the queen placement
	 * @return non-valid: "false"
	 */
	public static String NQueens(int N) {
		LinkStack<Integer> S = new LinkStack<Integer>();
		boolean newRow = false;
		int Qpos = 1;
		S.push(1);

		while(S.size() < N) { // while board is not full
			// Check if its a new row, set Queen to column 1
			if(newRow) {
				Qpos = 1;
				newRow = false;
			}
			// Fill in one row
			while(Qpos <= N) {
				boolean conflict = checkConflict(Qpos, S);
				if(!conflict) {
					S.push(Qpos);
					newRow = true;
					break;
				} else { // there is conflict
					Qpos++;
				}
			}
			// Every column has been tested, so we need to backtrack
			// Keep the position of the queen before popping
			while(!(S.isEmpty()) && (Qpos > N)) {
				Qpos = S.top() + 1;
				S.pop();
				newRow = false;
			}
			// Special case: no solution
			if(S.isEmpty() == true && (Qpos > N)) {
				return "False";
			}
		}
		return printStack(S);
	}
	
	private static boolean checkConflict(int pos, LinkStack<Integer> S) {
		// first make a clone of S because were going pop items
		LinkStack<Integer> cursor;
		try {
			cursor = S.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		int Qnum = cursor.size(); // we need to check for QNum number of queens
		for(int i = 0; i < Qnum; i++) { // beginning at column 1
			Integer temp = cursor.top();
			if((pos == temp) || (pos == (temp - i - 1)) || (pos == (temp + i + 1))) {
				return true;
			}
			cursor.pop();
		}
		return false;
	}
	
	private static String printStack(LinkStack<Integer> s) {
		String answer = "";
		int N = s.size();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if((j+1) == s.top()) {
					answer += "Q";
				} else {
					answer += "-";
				}
			}
			s.pop();
			answer += "\n";
		}
		return answer;
	} // end printStack
	
	/**
	 * Main method to test NQueens
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(NQueens(16));
	}
	
}
