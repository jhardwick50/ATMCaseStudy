package atmcasestudy;

import java.io.Serializable;

/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 * 
 */
public class BankDatabase implements Serializable{
	private Account[] accounts;
	private static final long serialVersionUID = 1L;
        
	public BankDatabase() {
		accounts = new Account[2];
		accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
		accounts[1] = new Account(98765, 56789, 200.0, 200.0);
	}// end BankDatabase constructor
	
	private Account getAccount(int accountNumber){
		for(Account currentAccount : accounts){
			if(currentAccount.getAccountNumber() == accountNumber){
				return currentAccount;
			}
		}
		
		return null;
	}// end method getAccount

	public boolean authenticateUser(int userAccountNumber, int userPIN){
		Account userAccount = getAccount(userAccountNumber);
		
		if(userAccount != null){
			return userAccount.validatePIN(userPIN);
		}else{
			return false;
		}
	}// end method authenticateUser
	
	public double getAvailableBalance(int userAccountNumber){
		return getAccount(userAccountNumber).getAvailableBalance();
	}// end method getAvailableBalance
	
	public double getTotalBalance(int userAccountNumber){
		return getAccount(userAccountNumber).getTotalBalance();
	}// end method getTotalBalance
	
	public void credit(int userAccountNumber, double amount){
		getAccount(userAccountNumber).credit(amount);
	}// end method credit
	
	public void debit(int userAccountNumber, double amount){
		getAccount(userAccountNumber).debit(amount);
	}// end method debit
}// end class BankDatabase
