package lab7;

/******************************************************************************************
 * SNode object is a of type T.
 * SNode is a linked list collection. The last node in a list will have a null link.
 * 
 * @author Ryan Schwarzkopf
 * 
 * @version Oct 22, 2022
 * @see IntNode
******************************************************************************************/
public class SNode<T> {
	private T data;
	private SNode<T> link;

	/**
	 * Default constructor initializes this nodes data to null and link to null
	 */
	public SNode() {
		data = null;
		link = null;
	}

	/**
	 * Constructor initializes this node's data to x and link to SNode parameter
	 * 
	 * @param x
	 * @param node
	 */
	public SNode(T x, SNode<T> node) {
		data = x;
		link = node;
	}

	/**
	 * Accessor method to get this Node's data
	 * @return data object in this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Mutator method to set the data in this Node
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Accessor method to get the link to the next SNode
	 * @return link to next node
	 */
	public SNode<T> getLink() {
		return (SNode<T>) link;
	}

	/**
	 * Mutator method to set the link to the next SNode
	 * @param link
	 */
	public void setLink(SNode<T> link) {
		this.link = link;
	}

	
	/**
	 * Count the number of nodes in linked list after parameter node
	 * 
	 * @precondition
	 *  head should not be a null pointer
	 * @param head
	 * 	SNode object should not be null
	 * @return
	 * 	number of nodes in this linked list
	 */
	public int listLength(SNode<T> head) {
		int count = 1; // the while loop will break on the last node without incrementing count, so count is set to 1.
		while(head.link!=null) {
			head = head.link;
			count++;
		}
		return count;
	}
}