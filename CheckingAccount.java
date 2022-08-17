package Account;

public class CheckingAccount extends Account {
	
	private static double FEE = 2.5;
	
	// default constructor
	public CheckingAccount() {
		super();
	}
	
	/**
	 * Param constructor to inlitilize CheckignAccount with a custom account
	 * number and custome fee
	 */
	public CheckingAccount(int accountNumber, double fee) {
		super(accountNumber);
		FEE = fee;
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
			
			//apply transaction fee
			balance -= FEE;
			System.out.printf("Fee %.2f Applied%n", FEE);
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
			if((amount+FEE)<= balance) {
				System.out.printf("Amount of %.2f withdawn fron account%n", amount);
				balance -= amount;
				balance -= FEE;
				System.out.printf("Fee of %.2f applied%n", FEE);
				System.out.printf("Current Balance: %.2f %n", balance);
			}
		}else {
			System.out.println("Negative amount cannot be withdrawn");
		}
	}
}
