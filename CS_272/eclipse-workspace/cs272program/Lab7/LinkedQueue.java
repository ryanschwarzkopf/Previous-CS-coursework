package lab7;
import java.util.NoSuchElementException;
/*********************************************************************************************************
 * LinkedQueue class is a collection of SNode objects of type T. The queue follows first in first out
 * protocol. The items in the queue are stored in a linked list. The front of the queue is the head 
 * node and the rear of the queue is the last node in the list. The front instance is always the 
 * head of the linked list, and the rear instance is always the tail of the linked list behind
 * the last element in the queue.
 * 
 * @author rschw
 * @version Oct 22, 2022
 * @param <T>
 * @see SNode
********************************************************************************************************/
public class LinkedQueue<T> implements QueueInterface<T> {
	private SNode<T> front;
	private SNode<T> rear;
	private int numElements;
	
	/**
	 * No argument constructor sets front and rear to null, and numElements to 0
	 * @postcondition front is null
	 * @postcondition rear is null
	 * @postcondition numElements is 0
	 */
	public LinkedQueue() {
		front = null;
		rear = null;
		numElements = 0;
	}
	
	/**
	 * Add item to the queue
	 * @postcondition Item added just before rear of linked list. If no items, front is set to t. numElements incremented
	 */
	public void enqueue(T t) {
		if(numElements == 0) {
			front = new SNode<T>(t, null);
			rear = front;
		} else {
			SNode<T> answer = new SNode<T>(t, rear.getLink());
			rear.setLink(answer); 
			rear = rear.getLink();
		}
		numElements++;
	}

	/**
	 * Take item from queue
	 * @postcondition front is now the item after the item just taken. numElements decremented
	 * @return T: front item in the queue
	 */
	public T dequeue() {
		if(numElements == 0) throw new NoSuchElementException("Queue underflow");
		T answer = front.getData();
		front = front.getLink();
		numElements--;
		if(numElements == 0) {
			rear = null;
		}
		return answer;
	}

	/**
	 * Get the front item in the queue
	 */
	public T front() {
		return front.getData();
	}

	/**
	 * Get the number of elements in the queue
	 * @return number of elements in the queue
	 */
	public int size() {
		return numElements;
	}

	/**
	 * Check if the queue is empty
	 * @return true: queue is empty
	 * @return false: queue has element(s)
	 */
	public boolean isEmpty() {
		return (numElements == 0);
	}

}
