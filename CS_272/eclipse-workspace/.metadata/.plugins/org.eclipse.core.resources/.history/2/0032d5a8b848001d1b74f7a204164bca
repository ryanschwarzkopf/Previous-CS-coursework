package Lab4;
import java.util.Arrays;

/******************************************************************************************
 * IntNode is a collection of int numbers.
 * IntNode is a linked list collection. The last node in a list will have a null link.
 * 
 * @author Ryan Schwarzkopf
 * 
 * @version Sep 27, 2022
 * @see IntArrayBag
******************************************************************************************/
public class IntNode {
	private int data;
	private IntNode link;

	/**
	 * Default constructor initializes this nodes data to 0 and link to null
	 */
	public IntNode() {
		data = 0;
		link = null;
	}

	/**
	 * Constructor initializes this node's data to x and link to IntNode parameter
	 * 
	 * @param x
	 * @param node
	 */
	public IntNode(int x, IntNode node) {
		data = x;
		link = node;
	}

	/**
	 * Accessor method to get this Node's data
	 * @return number in this node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Mutator method to set the data in this Node
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Accessor method to get the link to the next IntNode
	 * @return link to next node
	 */
	public IntNode getLink() {
		return link;
	}

	/**
	 * Mutator method to set the link to the next IntNode
	 * @param link
	 */
	public void setLink(IntNode link) {
		this.link = link;
	}

	/**
	 * Makes a new node with number newdata and link equal to this nodes link
	 * Sets link of this node to the new node 
	 * 
	 * @param newdata
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}
	
	/**
	 * Removes the node after this node
	 * Cannot be the last node in the list
	 * 
	 * @precondition
	 * 	this node's link is not null
	 */
	public void removeNodeAfterThis() {
		if(link != null) {
			link  = this.link.link;
		}
		else { // print an error statement if the last node in the list was passed as the parameter.
			System.out.println("Cannot remove node after last node");
		}
	}
	
	/**
	 * Count the number of nodes in linked list after parameter node
	 * 
	 * @precondition
	 *  head should not be a null pointer
	 * @param head
	 * 	IntNode object should not be null
	 * @return
	 * 	number of nodes in this linked list
	 */
	public static int listLength(IntNode head) {
		int count = 1; // the while loop will break on the last node without incrementing count, so count is set to 1.
		while(head.link!=null) {
			head = head.link;
			count++;
		}
		return count;
	}

	/**
	 * searches for data value in list
	 * 
	 * @precondition
	 * 	parameter should not be a null pointer
	 * @param head
	 * 	IntNode object should not be null
	 * @param data
	 * 	data to be searched for
	 * @return
	 */
	public static boolean search(IntNode head, int data) {
		if(head.data==data) return true;
		do {
			head = head.link;
			if(head.data==data) return true;
		} while(head.link!=null);
		return false;
	}
	
	/**
	 * Sorts all nodes including and after head node. (Selection Sort O(n^2))
	 * This method sorts the original linked list. It does not make any new nodes
	 * and the original linked list is no longer available.
	 * 
	 * @param head
	 * @return head
	 * @postcondition the return value is a head reference of a linked 
	 * list with exactly the same entries as the original list (including 
	 * repetitions, if any), but the entries in this list are sorted from 
	 * smallest to largest. The original linked list is no longer 
	 * available.
	 */
	public static IntNode listSort(IntNode head) {
		int length = IntNode.listLength(head);
		IntNode lowest;
		int temp;
		IntNode current;
		IntNode answer = head; // answer will point to the first node 
		
		for(int i=0;i<length;i++) { // for each node: set the lowest, current and 
			lowest = head;
			current = head;
			temp = head.data;
			for(int j=i+1;j<length;j++) { // move current node forward and check each node for lowest data
				current = current.link;
				if(current.data < lowest.data) {
					lowest = current;
				} // end inside loop
			} // end outside loop
			head.data = lowest.data;
			lowest.data = temp;
			head = head.link;
		} // end sort
		
		return answer;
	}
	
	/**
	 * Merge two linked lists and returns new linked list
	 * Both linked list parameters will be unchanged
	 * 
	 * @param a
	 * @param b
	 * @return head node to a new linked list 
	 */
	public static IntNode merge(IntNode a, IntNode b) {
		int lengthA = IntNode.listLength(a);
		int lengthB = IntNode.listLength(b);
		int[] list = new int[lengthA + lengthB];
		for(int i=0;i<lengthA;i++) { // add data from link list A to array
			list[i] = a.data;
			a = a.link;
		}
		for(int i=0;i<lengthB;i++) { // add data from link list B to array
			list[lengthA + i] = b.data;
			b = b.link;
		}
		Arrays.sort(list); // sort the array of data
		IntNode answer = new IntNode();	
		answer.data = list[0]; // Because of the way that addNodeAfterThis works, we set the data for the head of the linked list, and then add elements in reverse order
		for(int i=list.length-1;i>0;i--) { // 
			answer.addNodeAfterThis(list[i]);
		}
		return answer;	
	}
		
	/**
	 * String representation of linked list
	 * @return string representation of linked list
	 */
	public String toString() {
		IntNode cursor = new IntNode(data, link);
		String answer = "";
		while(cursor.link!=null) {
			answer += (Integer.toString(cursor.data));
			if(cursor.link != null)
				answer += "->";
			cursor = cursor.link;
		}
		answer += (Integer.toString(cursor.data));
		return answer;
	}
}
