package atmcasestudy;
/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

public class Screen extends JTextArea  implements ActionListener{

   
    
    public void displayMessage(String message) {
        this.setText(message);
        System.out.print(message);
    }//end method displayMessage

    public void displayMessageLine(String message) {
        this.setText(this.getText() + message + "\n");
        System.out.println(message);
    }//end method displayMessageLine

    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}//end class Screen
