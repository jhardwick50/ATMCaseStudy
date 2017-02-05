package atmcasestudy;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
public class ATM extends JFrame {

    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase;

    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATM() {
        this.setLayout(new GridLayout(4, 1));
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();

        this.add(screen);
        this.add(keypad);
        this.add(cashDispenser);
        this.add(depositSlot);
    }//end ATM constructor

    public void run() {
        while (true) {
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome!");
                authenticateUser();
            }//end while

            performTransactions();
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessageLine("\nThank you! Goodbye!");
        }//end while
    }//end method run

    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput();
        screen.displayMessage("\nEnter your PIN: ");
        int pin = keypad.getInput();

        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

        if (userAuthenticated) {
            currentAccountNumber = accountNumber;
        } else {
            screen.displayMessageLine("\nInvalid account number or PIN. Please try again.");
        }
    }

    private void performTransactions() {
        Transaction currentTransaction = null;
        boolean userExited = false;

        while (!userExited) {
            int mainMenuSelection = displayMainMenu();
            System.out.println("Selection is: " + mainMenuSelection);
            switch (mainMenuSelection) {
                case BALANCE_INQUIRY:
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute();
                    keypad.waitForKeyPress();
                    break;
                case WITHDRAWAL:
                case DEPOSIT:

                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute();
                    
                    break;
                case EXIT:
                    screen.displayMessageLine("\nExiting the System...");
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
                    break;
            }//end switch
        }//end while
    }//end method performTransactions

    private int displayMainMenu() {
        screen.displayMessage("\nMain menu:\n");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Exit\n");
        screen.displayMessageLine("Enter a choice: ");
        return keypad.getKeyPress();
    }//end method displayMainMenu

    private Transaction createTransaction(int type) {
        Transaction temp = null;
        switch (type) {
            case BALANCE_INQUIRY:
                temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL:
                temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
                break;
            case DEPOSIT:
                temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
                break;
        }//end switch

        return temp;
    }//end method creatTransactions
}//end class ATM
