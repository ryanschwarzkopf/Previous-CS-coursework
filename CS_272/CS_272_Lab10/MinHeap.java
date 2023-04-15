package Lab10;
import java.util.ArrayList;
import java.util.Collections;

/**
 * MinHeap is a heap that: Stores Integers in binary tree. An elements children are not less
 * than that elements value. Therefore the lowest value will be the top of the tree. The tree is
 * stored in an ArrayList. The tree will always be a complete binary tree. And every element from 
 * index 0 to index: size will have an element. For an empty heap size=-1. Every level of the tree
 * except for the deepest will have an element and the deepest level will be filled as far left as
 * possible.
 * 
 * @author rschw
 * @version Nov 7, 2022
 * @see ArrayList
 * @see Collection
 */
public class MinHeap {
	private int size;
	private ArrayList<Integer> heap;
	
	// private methods for ease
	private int getLeftIndex(int parentIndex) { return (parentIndex * 2) + 1; }
	private int getRightIndex(int parentIndex) { return (parentIndex * 2) + 2; }
	private int getParentIndex(int index) { return (index-1) / 2; }
	
	private int leftVal(int index) { return heap.get(getLeftIndex(index)); }
	private int rightVal(int index) { return heap.get(getRightIndex(index)); }
	private int parentVal(int index) { return heap.get(getParentIndex(index)); }
	
	private void inOrderPrt(){
		if(size < 0) throw new IllegalArgumentException("Heap is empty");
		int index = 0;
		int k = 1;
		int j = 1;
		while(index <= size) {
			System.out.print(heap.get(index) + " ");
			if(k==1) {
				System.out.print("\n");
				j*=2;
				k=j+1;
			}
			k--;
			index++;
		}
	}
	
	/**
	 * Constructor
	 * @postcondition size: -1, heap: empty
	 */
	public MinHeap() {
		// size will be 0 at first element 
		size = -1;
		heap = new ArrayList<Integer>();
	}
	
	/**
	 * Add element to heap
	 * 
	 * @param val
	 * @postcondition heap is valid
	 */
	public void add(int val) {
		 heap.add(val);
		 size++;
		 
		 int index = size;
		 while(index!=-1 && parentVal(index) > val) {
			 int temp = parentVal(index);
			 heap.set(getParentIndex(index), val);
			 heap.set(index, temp);
			 index = getParentIndex(index);
		 }
	}
	
	/**
	 * remove an item from the heap
	 * removes top item from heap.
	 * 
	 * @precondition heap cannot be empty
	 * @return top of heap (min value of data set)
	 * @postcondition heap is valid
	 * @throws IllegalArgumentException
	 */
	public int remove() {
		if(size < 0) throw new IllegalArgumentException("Heap is empty");
		int answer = heap.get(0);
		heap.set(0, heap.get(size));
		heap.remove(size);
		size--;
		
		// ensure heap is valid
		boolean valid = false;
		int i = 0; // set index to root
		do {
			// while not valid swap 
			if(getLeftIndex(i) < size && leftVal(i) < heap.get(i)) {
				if(leftVal(i) < rightVal(i)) {
					// swap left
					Collections.swap(heap, getLeftIndex(i), i);
					i = getLeftIndex(i);
					//this.inOrderPrt(); System.out.println("\n");
				} else if((getRightIndex(i) < size) && (getLeftIndex(i) < size) && (rightVal(i) < leftVal(i))) {
					// swap right
					Collections.swap(heap, getRightIndex(i), i);
					i = getRightIndex(i);
					//this.inOrderPrt(); System.out.println("\n");
				} else { // children are equal: take left
					Collections.swap(heap, getLeftIndex(i), i);
					i = getLeftIndex(i);
				}
			} else if(getRightIndex(i) < size && rightVal(i) < heap.get(0)){
				// assume right is lowest because line 42 was passed
				Collections.swap(heap, getRightIndex(i), i);
				i = getRightIndex(i);
				//this.inOrderPrt(); System.out.println("\n");
			} else {
				// no if statements have activated so parent is least
				valid = true;
			}

		} while(!valid);
		return answer;
	}
	
	/**
	 * Get the top item of the heap
	 * 
	 * @precondition heap is not empty
	 * @return top item of the heap
	 * @throws IllegalArgumentException
	 */
	public int top() {
		if(size < 0) throw new IllegalArgumentException("Heap is empty");
		return heap.get(0);
	}
	
	public static void main(String args[]) {
		MinHeap h = new MinHeap();
		
		// fill heap
		System.out.println("Filling the heap: ");
		h.add(30);h.inOrderPrt();System.out.println("\n");h.add(20);h.inOrderPrt();System.out.println("\n");
		h.add(10);h.inOrderPrt();System.out.println("\n");h.add(25);h.inOrderPrt();System.out.println("\n");
		h.add(28);h.inOrderPrt();System.out.println("\n");h.add(24);h.inOrderPrt();System.out.println("\n");
		h.add(11);h.inOrderPrt();System.out.println("\n");h.add(5);h.inOrderPrt();System.out.println("\n");
		h.add(11);h.inOrderPrt();System.out.println("\n");h.add(12);h.inOrderPrt();System.out.println("\n");
		h.add(50);h.inOrderPrt();System.out.println("\n");h.add(40);h.inOrderPrt();System.out.println("\n");
		h.add(35);h.inOrderPrt(); System.out.println("\n");
		
		System.out.println("Top: " + h.top() + "\n");
		System.out.println("Removing from heap: ");
		System.out.println("Removed: " + h.remove()); h.inOrderPrt();System.out.println("\n");
		System.out.println("Removed: " + h.remove()); h.inOrderPrt();System.out.println("\n");
		System.out.println("Removed: " + h.remove()); h.inOrderPrt();System.out.println("\n");
		System.out.println("Removed: " + h.remove()); h.inOrderPrt();System.out.println("\n");
		System.out.println("Removed: " + h.remove()); h.inOrderPrt();System.out.println("\n");
	}
	
}
