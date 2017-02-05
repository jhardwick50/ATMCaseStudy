package atmcasestudy;
/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class DepositSlot extends JButton implements ActionListener {

    private boolean envelopeReceived = false;

    public DepositSlot() {
        super("Deposit Slot");

        addActionListener(this);

    }

    public void waitForDeposit() {
        while (!envelopeReceived) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {

            }
        }
        envelopeReceived = false;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        envelopeReceived = true;
        //System.out.println("deposit pressed");
    }

}
