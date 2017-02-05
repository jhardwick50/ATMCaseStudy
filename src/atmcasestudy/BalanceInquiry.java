package atmcasestudy;
/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
public class BalanceInquiry extends Transaction {
	
	public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
	}//end BalanceInquiry constructor
	
	@Override
	public void execute(){
		BankDatabase bankDatabase = getBankDatabase();
		
		
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());
		
		getScreen().displayMessageLine("\nBalance Information:");
		getScreen().displayMessage(" - Available balance: ");
		getScreen().displayDollarAmount(availableBalance);
		getScreen().displayMessage("\n - Total balance:     ");
		getScreen().displayDollarAmount(totalBalance);
		getScreen().displayMessageLine("");
	}//end method execute
}//end class BalanceInquiry

