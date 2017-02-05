package atmcasestudy;
/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class CashDispenser extends JButton implements ActionListener{
        
        
	private final static int INITIAL_COUNT = 500;
	private int count;
	private boolean cashInSlot = true;
        
        
        @SuppressWarnings("LeakingThisInConstructor")
	public CashDispenser(){
            super("Cash Slot");
            
		count = INITIAL_COUNT;
                addActionListener(this);
	}//end CashDispenser constructor 
        
        public void waitForCashRemoval(){
           System.out.println("waiting for cash removal");
            while(cashInSlot){
                try{
                    Thread.sleep(10);
                }
                catch(InterruptedException ie){
                    
                }
            }
            System.out.println("cash removed");
            setText("Cash Slot");
            print(this.getGraphics());
            setVisible(false);
            setVisible(true);
            cashInSlot = true;
        }
        
	
	public void dispenseCash(int amount){
		int billsRequired = amount / 20;
		count -= billsRequired;
	}//end method dispenseCash
	
	public boolean isSufficientCashAvailable(int amount){
		int billsRequired = amount / 20;
		
		if( count >= billsRequired){
			return true;
		}else{
			return false;
		}
	}//end method isSufficientCashAvailable

    @Override
    public void actionPerformed(ActionEvent e) {
        cashInSlot = false;
       // System.out.println(" cash button pressed");
    }
}//end class CashDispenser
