
package atmcasestudy;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
public class Withdrawal extends Transaction {
	private int amount;
	private Keypad keypad;
	private CashDispenser cashDispenser;
	
	private final static int CANCELED = 6;
	
	public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
		
		keypad = atmKeypad;
		cashDispenser = atmCashDispenser;
	}//end Withdrawal constructor
	
	@Override
	public void execute(){
		boolean cashDispensed = false;
		double availableBalance;
		
		BankDatabase bankDatabase = getBankDatabase();
		
		
		do{
			amount = displayMenuOfAmounts();
			
			if(amount != CANCELED){
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
				
				if( amount <= availableBalance){
					if(cashDispenser.isSufficientCashAvailable(amount)){
						bankDatabase.debit(getAccountNumber(), amount);
						cashDispenser.dispenseCash(amount);
						cashDispensed =  true;
						
						getScreen().displayMessage("\nYour cash has been dispensed. Please take cash amount.");
                                                cashDispenser.waitForCashRemoval();
                                                
					}else{
						getScreen().displayMessage("\nInsufficient cash available in the ATM.\nPlease choose a smaller amount.");
					}//end if
				}else{
					getScreen().displayMessage("\nInsufficient cash available in the ATM.\nPlease choose a smaller amount.");
				}//end if
			}else{ //user chose CANCEL
				getScreen().displayMessageLine("\nCanceling transaction...");
				return;
			}//end if
		} while (!cashDispensed);
	}//end method execute

	private int displayMenuOfAmounts(){
		int userChoice = 0;
		
		
		
		int[] amounts = { 0, 20, 40, 60, 100, 200 };
		
		while(userChoice == 0){
			getScreen().displayMessage("\nWithdrawal Menu:\n");
			getScreen().displayMessageLine("1 - $20");
			getScreen().displayMessageLine("2 - $40");
			getScreen().displayMessageLine("3 - $60");
			getScreen().displayMessageLine("4 - $100");
			getScreen().displayMessageLine("5 - $200");
			getScreen().displayMessageLine("6 - Cancel Transaction");
			getScreen().displayMessageLine("\nChoose a withdrawal amount: ");
			
			int input = keypad.getInput();
			
			switch(input){
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					userChoice = amounts[input];
					break;
				case CANCELED:
					userChoice = CANCELED;
					break;
				default:
					getScreen().displayMessageLine("\nInvalid selection. tey again.");
			}//end switch
		}//end while
		
		return userChoice;
	}//end method displayMenuOfAmounts
}//end class Withdrawal
