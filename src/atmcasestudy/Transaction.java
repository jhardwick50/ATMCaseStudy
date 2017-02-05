package atmcasestudy;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
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
