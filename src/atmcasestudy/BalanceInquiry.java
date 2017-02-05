package atmcasestudy;
/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
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
		
		getScreen().displayMessage("\nBalance Information:\n");
		getScreen().displayMessageLine(" - Available balance: ");
		getScreen().displayDollarAmount(availableBalance);
		getScreen().displayMessageLine(" - Total balance:     ");
		getScreen().displayDollarAmount(totalBalance);
		getScreen().displayMessageLine("");
                
                
	}//end method execute
}//end class BalanceInquiry


