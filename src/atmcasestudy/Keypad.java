package atmcasestudy;

/**
 * @author Java How to Program Deitel & Deitel Ch.34
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Keypad extends JPanel implements ActionListener {

    private String keyValue = "";
    private boolean keyPressed = false;

    private String input = "";

    public Keypad() {
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

        JButton zero = new JButton("0");
        zero.addActionListener(this);
        this.add(zero);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        this.add(clear);

        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        this.add(enter);

    }

    public int getInput() {
        keyValue = "";
        keyPressed = false;
        while (true) {
            
            if (keyPressed) {
                if (keyValue.equals("Enter")){
                    break;
                }
                else if (keyValue.equals("Clear")) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        while (keyPressed == true){
            
        }
        keyValue = e.getActionCommand();
        keyPressed = true;
    }
}
