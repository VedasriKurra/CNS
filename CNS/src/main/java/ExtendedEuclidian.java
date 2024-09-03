import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExtendedEuclidian extends JFrame {

    private JLabel labelNumber1, labelNumber2;
    private JTextField textFieldNumber1, textFieldNumber2;
    private JButton submitButton;

    public ExtendedEuclidian() {
        setTitle("GCD Calculator");
        setSize(300, 150);
        

        // Initialize components
        labelNumber1 = new JLabel("Number 1:");
        labelNumber2 = new JLabel("Number 2:");

        textFieldNumber1 = new JTextField(10);
        textFieldNumber2 = new JTextField(10);

        submitButton = new JButton("Submit");

        // Set layout manager
        setLayout(new GridLayout(3, 2));

        // Add components to the frame
        add(labelNumber1);
        add(textFieldNumber1);
        add(labelNumber2);
        add(textFieldNumber2);
        add(new JLabel()); // Empty label for spacing
        add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplayGCD();
            }
        });
    }

    private void calculateAndDisplayGCD() {
        try {
            int number1 = Integer.parseInt(textFieldNumber1.getText());
            int number2 = Integer.parseInt(textFieldNumber2.getText());

            int arr[] = calculateGCD(number1, number2);

            JOptionPane.showMessageDialog(this, "GCD: " + arr[0]+"\nt value:"+arr[1]+"\ns value:"+arr[2], "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            
        }
    }

    private int[] calculateGCD(int a, int b) {
    int s1=1;
    int s2=0;
    int t1=0;
    int t2=1;
    int s=0;
    int t=0;
    int r1=a;
    int r2=b;
    int q;
    int r;
        while (r2 != 0) {
            q=r1/r2;
            r=r1-q*r2;
            r1=r2;
            r2=r;
            t=t1-q*t2;
            s=s1-q*s2;
            s1=s2;
            s2=s;
            t1=t2;
            t2=t;
        }
       int arr[]= {Math.abs(r1),t1,s1};
        return arr;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExtendedEuclidian().setVisible(true);
            }
        });
    }
}