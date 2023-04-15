package lab7;
import java.util.EmptyStackException;
/********************************************************************************************************
 * LinkStack class is a collection of SNode objects of type T. The stack follows first in last out
 * protocol. The items in the stack are stored in a linked list. The top of the stack is the head 
 * node and the bottom of the stack is the last node in the list. The top instance is always the 
 * head of the linked list.
 * 
 * @author rschw
 * @version Oct 22, 2022
 * @param <T>
 * @see SNode
********************************************************************************************************/
public class LinkStack<T> implements StackInterface<T>, Cloneable {
	private SNode<T> top;
	
	/**
	 * No argument constructor sets stack to null
	 * @postcondition top is null 
	 */
	public LinkStack() {
		top = null;
	}
	
	/**
	 * Take an item off of the stack
	 * @postcondition Top item is taken off of the stack
	 * @return T: the object on the top of the stack
	 */
	public T pop() {
		if(top == null) throw new EmptyStackException();
		T answer = top.getData();
		top = top.getLink();
		return answer;
	}
	
	/**
	 * Add an item to the stack
	 * @postcondition Top of the stack is this item
	 */
	public void push(T t) {
		top = new SNode<T>(t, top); 
	}
	
	/**
	 * Accessor method to get the item at the top of the stack.
	 * @return item at the top of the stack
	 */
	public T top() {
		if(top == null) throw new EmptyStackException();
		return top.getData();
	}
	
	/**
	 * Get the number of items in the stack
	 * @return number of items in the stack
	 */
	public int size() {
		if(top == null) return 0;
		return top.listLength(top);
	}
	
	/**
	 * Check if the stack is empty
	 * @note if the stack has elements, but the top is set to null, this method will return true
	 * @return true: stack is empty
	 * @return false: stack isn't empty
	 */
	public boolean isEmpty() {
		return (top == null);
	}
	
	/**
	 * Get a copy of this stack
	 * @return new LinkStack copy of this LinkStack
	 */
	public LinkStack<T> clone() throws CloneNotSupportedException {
		@SuppressWarnings("unchecked")
		LinkStack<T> answer = (LinkStack<T>) super.clone();
		return answer;
	}
}
