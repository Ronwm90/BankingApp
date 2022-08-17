package Account;
//Base Class 
//abstract class
public abstract class Account {

	private int accountNumber;
	
	//balance amount
	protected double balance;
	
	public Account() {
		
	}

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
		balance = 0;
	}
	
	//getter
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	//abstract
	/**
	 * Func to deposit funds to account so long as param > 0
	 * apply transaction fee for checking account validity
	 * 
	 * @param amount deposit value 
	 * 
	 */
	public abstract void deposit (double amount);
	
	/**
	 * Func to withdraw funds so long as 
	 * amount must be > 0
	 * amount must be <= balance
	 * 
	 * @param amount withdraw amount
	 */
	public abstract void withdraw (double amount);
	
	
}
