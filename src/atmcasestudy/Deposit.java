package atmcasestudy;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
public class Deposit extends Transaction {

    private double amount;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private final static int CANCELED = 0;

    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
        super(userAccountNumber, atmScreen, atmBankDatabase);

        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    }

    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();

        amount = promptForDepositAmount();

        if (amount != CANCELED) {
            getScreen().displayMessage("\nPlease insert a deposit envelope containing ");
            getScreen().displayDollarAmount(amount);
            getScreen().displayMessageLine(".");

            depositSlot.waitForDeposit();

            getScreen().displayMessage("\nYour envelope has been received.\nNOTE: The money just deposited will not be available until we verify the amount of any enclosed cash and your chacks clear.");
            bankDatabase.credit(getAccountNumber(), amount);

        } else {
            getScreen().displayMessageLine("\nCanceling transaction...");
        }//end else
    }//end method execute

    private double promptForDepositAmount() {

        getScreen().displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel):");
        int input = keypad.getInput();

        if (input == CANCELED) {
            return CANCELED;
        } else {
            return (double) input / 100;
        }//end else
    }//end method promptForDepositAmount
}//end class Deposit
