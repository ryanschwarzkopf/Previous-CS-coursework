package Lab3;
 
import java.util.Arrays;

/********************************************************************************************
 * Employee class is a collection of employee data:
 * 	name, id, age, state, zipCode, advisors
 * Employee implements Cloneable.
 * Class includes clone, equals, and toString methods
 * 
 * @author Ryan Schwarzkopf
 * 
 * @version Sep 20, 2022
 *
 ********************************************************************************************/
public class Employee implements Cloneable{
	private String name;
	private int id;
	private int age;
	private String state;
	private int zipCode;
	private String[] advisors;
	
	/**
	 * Constructor initializes name, state, advisors to null; and id, age, and zipCode to 0.
	 *
	 * @postcondition
	 * 	This Employee has values null and 0
	 */
	public Employee() {
		name=null;
		id=0;
		age=0;
		state=null;
		zipCode=0;
		advisors=null;
	}
	
	/**
	 * Constructor initializes all instance variables to another employee object.
	 * 
	 * @postcondition
	 * 	This Employee's instance variables are set to obj's instance variables
	 * 
	 * @param obj
	 * 	Employee object, cannot be a null pointer
	 */
	public Employee (Employee obj) {
		name=obj.name;
		id=obj.id;
		age=obj.age;
		state=obj.state;
		zipCode=obj.zipCode;
		advisors=Arrays.copyOfRange(obj.advisors, 0, obj.advisors.length);
	}
	
	public Employee clone() {
		Employee answer;     
	      try
	      {
	         answer = (Employee) super.clone();
	      }
	      catch (CloneNotSupportedException e)
	      {  
	         throw new RuntimeException
	         ("This class does not implement Cloneable");
	      }
	      answer.advisors = advisors.clone();
	      return answer;
	}
	
	/**
	 * Accessor method to get the name of this Employee object.
	 * @return
	 * 	the current name of Employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator method to set the name of this Employee object.
	 * @param name
	 * 	Name to be set to this Employee object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method to get the ID of this Employee object.
	 * @return
	 * 	the current ID of this Employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutator method to set the ID of this Employee object.
	 * @param id
	 * 	ID to be set to employee object
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Accessor method to get the age of this Employee object.
	 * @return
	 * 	the current age of this Employee
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Mutator method to set the age of this Employee object
	 * @param age
	 * 	age to be set to employee object
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Accessor method to get the state of this Employee object.
	 * @return
	 * 	the current state of this Employee
	 */
	public String getState() {
		return state;
	}

	/**
	 * Mutator method to set the state of this Employee object.
	 * @param state
	 * 	state to be set to employee object
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Accessor method to get zip code of this Employee object.
	 * @return
	 * 	the current zip code of this employee
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Mutator method to set the zip code of this Employee object.
	 * @param zipCode
	 * 	zip code to be set to employee object
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Accessor method to get the advisors of this Employee object.
	 * @return
	 * 	a copy of this employee's advisor array
	 */
	public String[] getAdvisors() {
		return Arrays.copyOfRange(advisors, 0, advisors.length);
	}

	/**
	 * Mutator method to set the advisors of this Employee object.
	 * This method sets advisors to a copy of the parameter array object
	 * @param advisors
	 * 	advisors to be set to employee's advisors
	 */
	public void setAdvisors(String[] advisors) {
		this.advisors = Arrays.copyOfRange(advisors, 0, advisors.length);
	}

	/**
	 * toString method shows instance variable values of this Employee
	 * this method does not show advisors
	 */
	public String toString() {
		return "name=" + name + " id=" + id + " age=" + age +
			   " state=" + state + " zip=" + zipCode;
	}

	/**
	 * Equals method compares caller employees id with b's id
	 * @param b
	 * 	should not be null pointer
	 * @return
	 * 	true if ids are equal
	 * 	false if ids are not equal
	 */
	public boolean equals(Employee b) {
		if(id==b.id) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee a = new Employee();
		a.setName("Harry");
		a.setId(1432);
		a.setAge(34);
		a.setState("New Mexico");
		a.setZipCode(88001);
		String[] advisors = {"Nancy", "Reggie", "Sally"};
		a.setAdvisors(advisors);
		Employee b = new Employee(a);
		System.out.println(b.equals(a));
		
		System.out.println(b.getName());
		System.out.println(b.getId());
		b.setId(00001);
		System.out.println(b.equals(a));
		System.out.println(b.getAge());
		System.out.println(b.getState());
		b.setState("New York");
		System.out.println(b.getState());
		System.out.println(a.getState());
		System.out.println(b.getZipCode());
		String[] temp = b.getAdvisors();
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		Employee c = a.clone();
		c.setId(0004);
		System.out.println("\n" + c.equals(a));
		System.out.println(c.toString());
	}

}
