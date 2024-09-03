
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplicativeInverseCalculator extends JFrame {

    private JLabel labelNumber, labelModulus;
    private JTextField textFieldNumber, textFieldModulus, resultTextField;
    private JButton calculateButton;

    public MultiplicativeInverseCalculator() {
        setTitle("Multiplicative Inverse Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        labelNumber = new JLabel("Enter Number:");
        labelModulus = new JLabel("Enter Modulus:");

        textFieldNumber = new JTextField(10);
        textFieldModulus = new JTextField(10);

        calculateButton = new JButton("Calculate");

        resultTextField = new JTextField(20);
        resultTextField.setEditable(false);

        // Set layout manager
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(labelNumber);
        add(textFieldNumber);
        add(labelModulus);
        add(textFieldModulus);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(new JLabel("Multiplicative Inverse:"));
        add(resultTextField);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMultiplicativeInverse();
            }
        });
    }

    private void calculateMultiplicativeInverse() {
        try {
            int number = Integer.parseInt(textFieldNumber.getText());
            int modulus = Integer.parseInt(textFieldModulus.getText());

            int inverse = calculateInverse(number, modulus);

            if (inverse != -1) {
                resultTextField.setText(String.valueOf(inverse));
            } else {
                resultTextField.setText("No multiplicative inverse (not coprime)");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int calculateInverse(int number, int modulus) {
        ExtendedGCDResult result = extendedGCD(number, modulus);

        if (result.gcd == 1) {
            // Ensure the result is positive
            int inverse = (result.x % modulus + modulus) % modulus;
            return inverse;
        } else {
            return -1; // No multiplicative inverse (not coprime)
        }
    }

    private ExtendedGCDResult extendedGCD(int a, int b) {
        int s1 = 1, s2 = 0, t1 = 0, t2 = 1, s = 0, t = 0, r1 = a, r2 = b, q, r;

        while (r2 != 0) {
            q = r1 / r2;
            r = r1 - q * r2;
            r1 = r2;
            r2 = r;
            t = t1 - q * t2;
            s = s1 - q * s2;
            s1 = s2;
            s2 = s;
            t1 = t2;
            t2 = t;
        }

        return new ExtendedGCDResult(Math.abs(r1), s1, t1);
    }

    private static class ExtendedGCDResult {
        int gcd;
        int x;
        int y;

        ExtendedGCDResult(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiplicativeInverseCalculator().setVisible(true);
            }
        });
    }
}



