package Lab2;

/**
 * Tester class tests Statistician and BankAccount classes.
 * @author rschw
 *
 */
public class Tester{
	public static void main(String[] args) {
		// Test Statistician class
		// Create Object st1 (1.3, 5.4, -12)
		System.out.println("Statistician Class:");
		Statistician st1 = new Statistician();
		System.out.println(st1.toString());
		st1.nextNumber(1.3);
		System.out.println(st1.toString());
		st1.nextNumber(5.4);
		System.out.println(st1.toString());
		st1.nextNumber(-12);
		System.out.println(st1.toString());
		System.out.println(st1.length() + " " + st1.last() + " " +
						   st1.smallest() + " " + st1.largest() + " " + 
						   st1.sum() + " " + st1.mean());	
		
		// Create Object st2 (0, 912, 1.1011)
		Statistician st2 = new Statistician();
		System.out.println("\n" + st2.toString());
		st2.nextNumber(0);
		System.out.println(st2.toString());
		st2.nextNumber(912);
		System.out.println(st2.toString());
		st2.nextNumber(1.1011);
		System.out.println(st2.toString());
		
		// Test combine method (st1 & st2), & Test IllegalArgumentException
		System.out.println("\n" + Statistician.combine(st1, st2));
		// Statistician st3 = new Statistician();
		// System.out.println(Statistician.combine(st1, st3));
		
		
		// Test BankAccount class
		System.out.println("\n\nBankAccount Class:");
		BankAccount ba1 = new BankAccount();
		BankAccount ba2 = new BankAccount(1000, 0.1);
		System.out.println(ba1.toString());
		System.out.println(ba2.toString());
		ba1.setBalance(12249.57);
		ba1.setInterestRate(0.03);
		System.out.println("\n" + ba1.toString());
		System.out.println(ba1.getBalance() + " " + ba1.getInterestRate());
		ba1.deposit(1234.56);
		System.out.println(ba1.toString());
		ba1.withdrawal(4000);
		System.out.println(ba1.toString());
		ba1.addInterest(1);
		System.out.println(ba1.toString());
	} // end main
} // end class Tester