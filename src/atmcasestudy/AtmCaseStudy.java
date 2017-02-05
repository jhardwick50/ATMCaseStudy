/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
package atmcasestudy;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Jason
 */
public class AtmCaseStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        ATM atm = new ATM();
        
        
	atm.setVisible(true);
        atm.setSize(500, 500);
        atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        atm.run();
	}



        
     
    
    
}
