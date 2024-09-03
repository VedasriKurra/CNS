

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GCDCalculator extends JFrame {

    private JLabel labelNumber1, labelNumber2;
    private JTextField textFieldNumber1, textFieldNumber2;
    private JButton submitButton;

    public GCDCalculator() {
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

            int gcd = calculateGCD(number1, number2);

            JOptionPane.showMessageDialog(this, "GCD: " + gcd, "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int calculateGCD(int a, int b) {
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
           
        }
       return Math.abs(r1);
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GCDCalculator().setVisible(true);
            }
        });
    }
}