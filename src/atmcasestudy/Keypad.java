package atmcasestudy;

/**
 * CIS 314 Java Programming
 * Jason Hardwick
 *  2/5/17
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Keypad extends JPanel implements ActionListener {
    
    
    private String keyValue = "";
    private boolean keyPressed = false;

    private String input = "";
//create keypad with grid layout
    public Keypad() {
        this.setLayout(new GridLayout(4, 3));
        
        
        
        JButton one = new JButton("1");
        one.addActionListener(this);
        this.add(one);

        JButton two = new JButton("2");
        two.addActionListener(this);
        this.add(two);

        JButton three = new JButton("3");
        three.addActionListener(this);
        this.add(three);

        JButton four = new JButton("4");
        four.addActionListener(this);
        this.add(four);

        JButton five = new JButton("5");
        five.addActionListener(this);
        this.add(five);

        JButton six = new JButton("6");
        six.addActionListener(this);
        this.add(six);

        JButton seven = new JButton("7");
        seven.addActionListener(this);
        this.add(seven);

        JButton eight = new JButton("8");
        eight.addActionListener(this);
        this.add(eight);

        JButton nine = new JButton("9");
        nine.addActionListener(this);
        this.add(nine);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        this.add(clear);

        JButton zero = new JButton("0");
        zero.addActionListener(this);
        this.add(zero);

        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        this.add(enter);

        
    }
//figure out which button is pressed and waht to do for each.
    public int getInput() {
        input = "";
        keyValue = "";
        keyPressed = false;
        while (true) {

            if (keyPressed) {
                if (keyValue.equals("Enter")) {
                    break;
                } else if (keyValue.equals("Clear")) {
                    input = "";
                    System.out.println();
                } else {
                    input = input + keyValue;
                    System.out.print(keyValue);
                    

                }
                keyValue = "";
                keyPressed = false;
            }
        }
        int result = Integer.parseInt(input);
        input = "";

        return result;
    }
//make sure keys pressed are numbers, not enter or clear.
    public int getKeyPress() {
        input = "";
        keyValue = "";
        keyPressed = false;
        while (true) {

            if (keyPressed && !keyValue.equals("Enter") && !keyValue.equals("Clear")) {
                input = keyValue;
                keyValue = "";
                keyPressed = false;
                return Integer.parseInt(input);
            }
        }

        
    }
    //wait for keys to be pressed.
    public void waitForKeyPress() {
        input = "";
        keyValue = "";
        keyPressed = false;
        while (!keyPressed) {

             try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {

            }
            
        }

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        while (keyPressed == true) {
           
        }
        keyValue = e.getActionCommand();
        keyPressed = true;
    }
}
