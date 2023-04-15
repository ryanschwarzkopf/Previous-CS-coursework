package lab7;
/*******************************************************************************************
 * ArrayListStack is a collection of SNode objects of type T. The stack follows first
 * in last out protocol. Data is put into a partially filled array at the left/beginning
 * of the array. The bottom of the stack is at data[0] and the last item is at
 * data[manyItems-1]. ManyItems is the number of items in the stack.
 * 
 * @author rschw
 * @version Oct 22, 2022
 * @param <T>
 * @see SNode
*******************************************************************************************/
import java.util.EmptyStackException;

public class ArrayListStack<T> implements StackInterface<T>{
	private int manyItems;
	private Object[] data;
	
	/**
	 * No argument constructor sets an empty array of size 10 and manyItems to 0
	 * @postcondition data is a empty array of 10 elements
	 * @postcondition manyItems is 0
	 */
	public ArrayListStack() {
		data = new Object[10];
		manyItems = 0;
	}
	
	/**
	 * Take an item off of the stack
	 * @postcondition Top item is taken off of the stack, manyItems decremented
	 * @return T: the object on the top of the stack
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		if(manyItems == 0) throw new EmptyStackException();
		T answer = (T) data[--manyItems];
		data[manyItems] = null;
		return answer;
	}
	
	/**
	 * Add an item to the stack. The size of data is checked and modified if necessary using ensureCapacity
	 * @postcondition This item is top of the stack, manyItems incremented
	 */
	public void push(T t) {
		if(manyItems == data.length) ensureCapacity((manyItems * 2) + 1);
		data[manyItems] = t;
		manyItems++;
	}

	/**
	 * Get the item on the top of the stack
	 * @return T: item on the top of the stack
	 */
	@SuppressWarnings("unchecked")
	public T top() {
		if(manyItems == 0) throw new EmptyStackException();
		return (T) data[manyItems-1];
	}
	
	/**
	 * Get the number of items in the stack
	 * @return ManyItems
	 */
	public int size() {
		return manyItems;
	}

	/**
	 * See if the stack is empty
	 * @return true: stack is empty
	 * @return false: stack isn't empty
	 */
	public boolean isEmpty() {
		return (manyItems == 0);
	}
	
	/**
	 * Make sure data is big enough for the stack
	 * @param min
	 * @postcondition stack is now in a bigger array at least min items long
	 */
	public void ensureCapacity(int min) {
		Object[] newList = new Object[min];
		System.arraycopy(data, 0, newList, 0, manyItems);
		data = newList;
	}
	
}
