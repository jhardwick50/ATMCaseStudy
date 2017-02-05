package atmcasestudy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
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
        System.out.println("deposit pressed");
    }

}
