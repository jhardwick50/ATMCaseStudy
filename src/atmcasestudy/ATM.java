package atmcasestudy;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
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
        
        this.setLayout(new GridLayout(5, 1));
        JLabel name = new JLabel();
        name.setText("<html>CIS 314 <br/> Jason Hardwick <br/> 2/5/17</html>");
        this.add(name);
        
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

    public void run()  {
        loadDatabase();  
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
    
    //method to save serialized BankDatabase and therefore Account
    private void saveDatabase() {
        
        try {
            FileOutputStream fs = new FileOutputStream("atm.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(bankDatabase);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //Deserialize the database
    private void loadDatabase() {
        
        try {
            FileInputStream fi = new FileInputStream("atm.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            bankDatabase = (BankDatabase)oi.readObject();
            oi.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
    
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

    private void performTransactions()  {
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
                    saveDatabase();
                    
                case DEPOSIT:

                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute();
                    
                    saveDatabase();
                    
                    break;
                case EXIT:
                    screen.displayMessageLine("\nExiting the System...");
                    userExited = true;
                    saveDatabase();
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
    
    public static String formatDollarAmount(double amount) {
        DecimalFormat myFormatter = new DecimalFormat("$###,###.##");
        return myFormatter.format(amount);
    }
}//end class ATM
