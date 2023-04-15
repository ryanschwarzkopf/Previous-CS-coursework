package Lab3;

/*******************************************************************************
 * An Employee set is an array of Employee objects
 * The same employee may not appear multiple times in a set.
 * This bag was developed from the IntArrayBag class. Credit to Michael Main
 * 
 * @note
 * 	(1) The capacity of one of these bags can change after it's created, but
 *   the maximum capacity is limited by the amount of free memory on the 
 *   machine. The constructor, addItem, clone, 
 *   and union will result in an OutOfMemoryError
 *   when free memory is exhausted.
 *   <p>
 *   (2) A bag's capacity cannot exceed the maximum integer 2,147,483,647
 *   (Integer.MAX_VALUE). Any attempt to create a larger capacity
 *   results in a failure due to an arithmetic overflow. 
 *   <p>
 *   (3) Because of the slow linear algorithms of this
 *   class, large bags will have poor performance.
 * @author Ryan Schwarzkopf
 * 
 * @version Sep 19, 2022
 * @see IntArrayBag
 * 
 *
 ******************************************************************************/
public class EmployeeSet {
	int manyItems;
	Employee[] data;

	/**
	 * Initialize an empty set with an initial capacity of 10. Note that the
	 * add method works efficiently (without needing more
	 * memory) until this capacity is reached.
	 * @postcondition
	 * 	This set is empty and has an initial capacity of 10
	 */
	public EmployeeSet() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new Employee[INITIAL_CAPACITY];
	}

	/**
	 * Accessor method to get the number of employees in this set.
	 * @return
	 * 	the number of employees in this set
	 */
	public int size() {
		return manyItems;
	}

	/**
	 * Accessor method to get the current capacity of this set.
	 * The add method works efficiently (without needing
	 * more memory) until this capacity is reached.
	 * @return
	 * 	the current capacity of this set
	 */
	public int capacity() {
		return data.length;
	}

	/**
	 * Add a new employee to this set. If the new employee would take this
	 *  beyond its current capacity, then the capacity is increased
	 *  before adding the new employee.
	 * @param a
	 * 	The new employee being added
	 */
	public void add(Employee a) {
		if (manyItems == data.length)
	      {  // Ensure twice as much space as we need.
	         ensureCapacity((manyItems + 1)*2);
	      }

	      data[manyItems] = a;
	      manyItems++;
	}

	/**
	 * Remove one employee from the set
	 * @param eid
	 * 	the employee to remove from the set
	 * @return
	 * 	If the target was found in the set, then on copy of
	 * 	target was removed and the method returns true.
	 * 	Otherwise the set remains unchanged and the method returns false
	 */
	public boolean remove(int eid) {
		int index; // The location of target in the data array.
	       
	    // First, set index to the location of target in the data array,
	    // which could be as small as 0 or as large as manyItems-1; If target
	    // is not in the array, then index will be set equal to manyItems;
	    for (index = 0; (index < manyItems) && (eid != data[index].getId()); index++)
	       // No work is needed in the body of this for-loop.
	       ;
	       
	    if (index == manyItems)
	       // The target was not found, so nothing is removed.
	       return false;
	    else
	    {  // The target was found at data[index].
	       // So reduce manyItems by 1 and copy the last element onto data[index].
	       manyItems--;
	       data[index] = data[manyItems];
	       return true;
	    }
	}
	
	/**
	 * Change the current capacity of this set.
	 * @param minimumCapacity
	 * 	the new capacity of this set
	 * @postcondition
	 * 	This set's capacity was already at or greater to at least minimumCapacity.
	 * 	If the capacity was already at or greater than minimumCapacity,
	 * 	then the capacity is left unchanged.
	 */
	private void ensureCapacity(int minimumCapacity) {
		Employee[] biggerArray;
	      
	    if (data.length < minimumCapacity)
	    {
	       biggerArray = new Employee[minimumCapacity];
	       System.arraycopy(data, 0, biggerArray, 0, manyItems);
	       data = biggerArray;
	    }
	}

	/**
	 * Accessor method to see if an employee is in the data set
	 * @param eid
	 * 	the id of the employee being searched for
	 * @return
	 * 	if the employee is found: true
	 * 	if the employee is not found: false
	 */
	public boolean contains(int eid) {
		boolean answer;
	    int index;
	      
	    answer = false;
	    for (index = 0; index < manyItems; index++)
	       if (eid == data[index].getId())
	          answer = true;
	    return answer;
	}

	public static void main(String[] args) {
		Employee a = new Employee();
		Employee b = new Employee();
		EmployeeSet z = new EmployeeSet();
		a.setId(1);
		b.setId(2);
		z.add(a);
		z.add(b);
		System.out.println(z.contains(2));
		System.out.println(z.size());
		System.out.println(z.remove(2));
		System.out.println(z.contains(2));
		System.out.println(z.size());
		System.out.println(z.capacity());
		
	} // end main
	
} // end class