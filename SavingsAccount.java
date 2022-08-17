package Account;
//savings child class
//Has interest rate
//method to appl interest
public class SavingsAccount extends Account {
	private double interestRate;
	
	
	// default constructor
	public SavingsAccount() {
		super();
	}
	
	/**
	 * Param constructor to inlitilize savings accoutn  withj custom account number and 
	 * interest rate.
	 */
	public SavingsAccount(int accountNumber, double fee) {
		super(accountNumber);
		this.interestRate = interestRate;
	}
	
	//getter function to
    public double getInterestRate() {
    	return this.interestRate;
    }	
    
    public void setInterestRate(double interestRate) {
    	this.interestRate = interestRate;
    }
    
    public double calcInterest() {
    	return balance * interestRate;
    }
    
    public void applyInterest() {
    	double interest = calcInterest();
    	System.out.printf("Interes amount %.2f added to balance%n", interest);
    	deposit(interest);
    }
    
    
    
	/**
	 * Func to deposit funds to account so long as param > 0
	 * apply transaction fee for checking account validity
	 * 
	 * @param amount deposit value 
	 * 
	 */
	public void deposit (double amount) {
		//check amount
		if (amount > 0) {
			balance += amount;
			System.out.printf("Amount %.2f deposited%n", amount);
			System.out.printf("Current Balance: %.2f%n", balance);
		}else {
			System.out.println("Negative amounts cannot be deposited");
		}
	}
	
	/**
	 * Func to withdraw funds so long as 
	 * amount must be > 0
	 * amount must be <= balance
	 * 
	 * @param amount withdraw amount
	 */
	public void withdraw (double amount) {
		if(amount > 0) {
			if((amount)<= balance) {
				System.out.printf("Amount of %.2f withdawn fron account%n", amount);
				balance -= amount;
				System.out.printf("Current Balance: %.2f %n", balance);
			}
		}else {
			System.out.println("Negative amount cannot be withdrawn");
		}
	}

}
