
package atmcasestudy;
/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
public class Account {
	private int accountNumber;
	private int pin;
	private double availableBalance;
	private double totalBalance;
	
	public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance){
		accountNumber = theAccountNumber;
		pin = thePIN;
		availableBalance = theAvailableBalance;
		totalBalance = theTotalBalance;
	}//end Account constructor
	
	public boolean validatePIN(int userPIN){
		if(userPIN == pin){
			return true;
		}else{
			return false;
		}
	}//end method validatePIN

	public double getAvailableBalance() {
		return availableBalance;
	}//end method getAvailableBalance

	public double getTotalBalance() {
		return totalBalance;
	}//end method getTotalBalance
	
	public void credit(double amount){
		totalBalance += amount;
	}//end method credit
	
	public void debit(double amount){
		availableBalance -= amount;
		totalBalance -= amount;
	}//end method debit
	
	public int getAccountNumber(){
		return accountNumber;
	}//end method getAccountNumber
}//end class Account
