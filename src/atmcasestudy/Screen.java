package atmcasestudy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;

public class Screen extends JTextField implements ActionListener {

    public void displayMessage(String message) {
        this.setText(message);
        System.out.print(message);
    }//end method displayMessage

    public void displayMessageLine(String message) {
        this.setText(this.getText() + message + "\n");
        System.out.println(message);
    }//end method displayMessageLine

    public void displayDollarAmount(double amount) {
        DecimalFormat myFormatter = new DecimalFormat("$###,###.##");
        this.setText(myFormatter.format(amount));
        System.out.printf("$%,.2f", amount);
    }//end method displayDollarAmount

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//end class Screen
