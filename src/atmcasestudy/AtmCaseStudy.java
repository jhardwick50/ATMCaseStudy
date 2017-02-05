/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
