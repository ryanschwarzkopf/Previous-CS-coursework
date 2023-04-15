package Lab2;

/**
 * BankAccount saves a balance and a interest rate for an account.
 * Methods include: constructors, setters/getters, deposit, withdrawal, addInterest, and toString
 * @author rschw
 *
 */
public class BankAccount {
   
   private double balance = Double.NaN;
   private double intRate = Double.NaN;

   /**
    * Constructor sets initial balance and interest rate to 0.
    */
   public BankAccount() {
      balance = 0;
      intRate = 0;
   }

   /**
    * Constructor sets initial balance and interest rate
    * @param bank initial balance
    * @param rate initial interest rate
    */
   public BankAccount(double bank, double rate) {
      balance = bank;
      intRate = rate;
   }
   
   /**
    * Sets bank balance
    * @param bank new bank balance
    */
   public void setBalance(double bank) {
      balance = bank;
   }

   /**
    * Get current bank balance
    * @return balance
    */
   public double getBalance() {
      return balance;
   }

   /**
    * Sets new interest rate
    * @param rate new interest rate
    */
   public void setInterestRate(double rate) {
      intRate = rate;
   }

   /**
    * Get current interest rate
    * @return interest rate
    */
   public double getInterestRate() {
      return intRate;
   }

   /**
    * Make a deposit to bank balance
    * @param amount
    */
   public void deposit(double amount) {
      balance += amount;
   }

   /**
    * Make a withdrawal from bank balance
    * @param amount
    */
   public void withdrawal(double amount) {
      balance -= amount;
   }

   /**
    * Cash in your interest for X years to your balance. 
    * @param years
    */
   public void addInterest(int years) {
      balance += balance*intRate*years;
   }

   /**
    * Generate a string representation of this BankAccount.
    * @return a string representation of this BankAccount.
    */
   public String toString() {
      return "balance=" + balance + " interest_rate=" + intRate;
   }
} // end class BankAccount
