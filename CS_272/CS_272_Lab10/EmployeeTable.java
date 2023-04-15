package Lab10;
import Lab3.Employee;
import java.lang.Math;

/*****************************************************************************************************************************************
 * EmployeeTable stores employees in an array. Employees are not guaranteed to be found
 * in constant time. This table does not modify its size or rehash. Most employees can
 * be found with constant time, however once the numItems / arraySize reaches higher than
 * 0.75 employees will take longer to search and the last employee added will take O(n) time
 * 
 * 
 * Key = employee_no % arraySize
 * LoadFactor = numItems / arraySize
 * 
 * @author schw
 *
****************************************************************************************************************************************/
public class EmployeeTable implements Cloneable{
	private Employee[] data;
	private boolean[] used;
	private int numItems;
	
	private int getKey(int num) {
		return num % data.length;
	}
	
	/**
	 * Default constructor
	 * @postcondition hash table size is 10, numItems is 0, and used[] is set to false
	 */
	public EmployeeTable() {
		data = new Employee[10];
		used = new boolean[10];
		for(int i=0;i<used.length;i++) used[i] = false;
		numItems = 0;
	}
	
	/**
	 * Constructor sets custom size
	 * @param size: size of hash table
	 * @postcondition hash table size is 10, numItems is 0, and used[] is set to false
	 */
	public EmployeeTable(int size) {
		data = new Employee[size];
		used = new boolean[size];
		for(int i=0;i<used.length;i++) used[i] = false;
		numItems = 0;
	}
	
	/**
	 * Put an employee into the hash table
	 * @param e: Employee
	 * @precondition (Unchecked!) Employee must have a unique employee number 
	 * @precondition Hash table cannot be full
	 * @postcondition Employee has been added to the hash table 
	 */
	public void put(Employee e) {
		if(numItems == data.length) { throw new IllegalArgumentException(); }
		int key = getKey(e.getEmployee_no());
		// while loop should not continue forever because the hash table will never be full
		while(used[key] == true) {
			if(key == data.length-1) {
				key = -1;
			}
			key++;
		}
		data[key] = e;
		used[key] = true;
		numItems++;
	}
	
	/**
	 * Remove an employee from the hash table
	 * 
	 * @param employee_num
	 * @return true: employee was removed
	 * @return false: employee was not found
	 */
	public boolean remove(int employee_num) {
		int key = search(employee_num);
		if(key == -1) {
			return false;
		} else {
			data[key] = null;
			numItems--;
			return true;
		}	
	}

	/**
	 * Search for an employee
	 * @param employee_num
	 * @return
	 */
	public int search(int employee_num) {
		int key = getKey(employee_num);
		// while loop will not continue forever because the hash table will never be full
		int iteration = 0;
		while((data[key] == null || data[key].getEmployee_no() != employee_num) && used[key] == true) {
			if(key == (data.length - 1)) key = -1;
			key++;
			iteration++;
			if(iteration > numItems) return -1;
		}
		if(used[key] == true && data[key].getEmployee_no() == employee_num) {
			return key;
		}
		return -1;
	}
	
	/**
	 * Get a string representation of this hash table
	 * 
	 */
	public String toString() {
		String answer = "";
		for(int i = 0; i<data.length; i++) {
			if(data[i] != null) {
				answer += String.valueOf(data[i].getEmployee_no());
			} else if(data[i] == null) {
				answer += "null";
			}
			answer += " ";
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// testing EmployeeTable
		// we make new employees using a constructor that sets their employee numbers only.
		// set the employee numbers randomly
		EmployeeTable myTable = new EmployeeTable();
		int temp = (int) (Math.random() * 10000);
		myTable.put(new Employee(temp));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		myTable.put(new Employee((int) (Math.random() * 10000)));
		System.out.println(myTable.toString());
		
		myTable.remove(temp);
		System.out.println(myTable.toString());
		myTable.remove(temp);
	}
}
