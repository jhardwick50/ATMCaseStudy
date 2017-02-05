package atmcasestudy;

/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
public abstract class Transaction {
	private int accountNumber;
	private Screen screen;
	private BankDatabase bankDatabase;
	
	public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	}//end Transaction constructor

	public int getAccountNumber(){
		return accountNumber;
	}//end method getAccountNumber
	
	public Screen getScreen(){
		return screen;
	}//end method getScreen
	
	public BankDatabase getBankDatabase(){
		return bankDatabase;
	}//end method getBankDatabase
	
	abstract public void execute();
	
}//end class Transaction
