package Account;

import java.util.Scanner;

public class AccountDriver {
public static void main(String[] args) {
	//Entry point of program
	
	Scanner keyboard = new Scanner(System.in);
	
	//Create array of accounts
	Account accounts [] = new Account[10];
	int numAccounts = 0;
	
	int choice;
	
	do {
		choice = menu(keyboard);
		System.out.println();
		
		if(choice == 1) {
			accounts[numAccounts++] = creatAccount(keyboard);
		}else if(choice == 2) {
			doDeposit(accounts, numAccounts, keyboard);
		}else if(choice == 3) {
			doWithdraw(accounts, numAccounts, keyboard);
			
		}else if(choice == 4) {
			applyInterest(accounts, numAccounts, keyboard);
			
		}else {
			System.out.println("GoodBye");
		}
		System.out.println();
	}while(choice != 5);

}

/** 
 * Account choice
 * 
 * @param keyboard
 * @return
 */
public static int accountMenu(Scanner keyboard) {
	System.out.println("Select Account Type: ");
	System.out.println("1. Checking Account");
	System.out.println("2. Savings Account");
	int choice;
	
	do {
		System.out.print("Enter choice");
		choice = keyboard.nextInt();
	}while(choice < 1 || choice > 2 );
		return choice;
	
}

public static int searchAccount(Account accounts [], int count, int accountNumber) {
	for(int i = 0; i<count; i++) {
		if(accounts[i].getAccountNumber() == accountNumber) {
			return i;
		}
	}
	return -1;
}
/** 
 * Func will deposit to selected acount

 */
public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
	
	//Get account number
	System.out.print("\n Please enter account Number: ");
	int accountNumber = keyboard.nextInt();
	
	//Search for account
	int index = searchAccount(accounts, count, accountNumber);
	if(index >= 0) {	
		//amount
		System.out.print("Please enter deposit amount: ");
		double amount = keyboard.nextDouble();
		accounts[index].deposit(amount);
	} else {
		System.out.println("No account found.");
	}
}

public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
	//Get account number
		System.out.print("\n Please enter account Number: ");
		int accountNumber = keyboard.nextInt();
		
		//Search for account
		int index = searchAccount(accounts, count, accountNumber);
		if(index >= 0) {	
			//amount
			System.out.print("Please enter withdraw amount: ");
			double amount = keyboard.nextDouble();
			accounts[index].withdraw(amount);
		} else {
			System.out.println("No account found.");
		}
}

public static void applyInterest(Account accounts [], int count, Scanner keyboard) {
	//Get account number
		System.out.print("\n Please enter account Number: ");
		int accountNumber = keyboard.nextInt();
		
		//Search for account
		int index = searchAccount(accounts, count, accountNumber);
		if(index >= 0) { 
            // must be instance of savings account
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
}
/**
 * Func to crerate new account

 */
public static Account creatAccount(Scanner keyboard) {
	Account account = null;
	int choice = accountMenu(keyboard);
	int accountNumber;
	System.out.println("Enter Account Number: ");
	accountNumber = keyboard.nextInt();
	if(choice == 1) {//checking
		System.out.print("Enter Transaction Fee: ");
		double fee = keyboard.nextDouble();
		
		account = new CheckingAccount(accountNumber, fee);
	}else {//savings
		System.out.print("Please enter interest rate: ");
		double ir = keyboard.nextDouble();
		account = new SavingsAccount(accountNumber, ir);
	}
	return account;
}
/**
 * Menu display options and get user choice
 * @param keyboard
 * @return
 */
public static int menu(Scanner keyboard) {
	System.out.println("Bank Account Menu");
	System.out.println("1. Create New Account");
	System.out.println("2. Deposit Funds");
	System.out.println("3. Withdraw Funds");
	System.out.println("4. Apply Interest");
	System.out.println("5. Quit");
	
	int choice;
	
	do {
		System.out.println("Enter choice");
		choice  = keyboard.nextInt();
	}while(choice < 1 || choice > 5);
	return choice;
}
}
