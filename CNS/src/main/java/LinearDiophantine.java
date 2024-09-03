import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinearDiophantine extends JFrame {

    private JLabel labelNumber1, labelNumber2, labelNumber3;
    private JTextField textFieldNumber1, textFieldNumber2, textFieldNumber3;
    private JButton submitButton;

    public LinearDiophantine() {
        setTitle("Linear Diophantine Solver");
        setSize(300, 150);
        

        // Initialize components
        labelNumber1 = new JLabel("Coefficient a:");
        labelNumber2 = new JLabel("Coefficient b:");
        labelNumber3 = new JLabel("Constant c:");

        textFieldNumber1 = new JTextField(10);
        textFieldNumber2 = new JTextField(10);
        textFieldNumber3 = new JTextField(10);

        submitButton = new JButton("Submit");

        // Set layout manager
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(labelNumber1);
        add(textFieldNumber1);
        add(labelNumber2);
        add(textFieldNumber2);
        add(labelNumber3);
        add(textFieldNumber3);
        add(new JLabel()); // Empty label for spacing
        add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplaySolution();
            }
        });
    }

    private void calculateAndDisplaySolution() {
        try {
            int a = Integer.parseInt(textFieldNumber1.getText());
            int b = Integer.parseInt(textFieldNumber2.getText());
            int c = Integer.parseInt(textFieldNumber3.getText());

            int[] result = solveLinearDiophantineEquation(a, b, c);

            JOptionPane.showMessageDialog(this,
                    "Particular Solution: x = " + result[1] + ", y = " + result[2] +
                            "\nGeneral Solution: x = " + result[1] + " + " + (b / result[0]) + "t, y = " +
                            result[2] + " - " + (a / result[0]) + "t", "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int[] solveLinearDiophantineEquation(int a, int b, int c) {
        int[] gcdResult = extendedGCD(a, b);

        if (c % gcdResult[0] == 0) {
            int x0 = gcdResult[1] * (c / gcdResult[0]);
            int y0 = gcdResult[2] * (c / gcdResult[0]);
            return new int[]{gcdResult[0], x0, y0};
        } else {
            return new int[]{1, 0, 0}; // No solution
        }
    }

    private int[] extendedGCD(int a, int b) {
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

        return new int[]{Math.abs(r1), s1, t1};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinearDiophantine().setVisible(true);
            }
        });
    }
}
