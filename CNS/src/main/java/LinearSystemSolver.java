import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinearSystemSolver extends JFrame {

    private JLabel labelEquation1, labelEquation2, labelResult;
    private JTextField textFieldA1, textFieldB1, textFieldC1, textFieldA2, textFieldB2, textFieldC2, resultTextField;
    private JButton solveButton;

    public LinearSystemSolver() {
        setTitle("Linear System Solver");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        labelEquation1 = new JLabel("Equation 1: a1x + b1y = c1");
        labelEquation2 = new JLabel("Equation 2: a2x + b2y = c2");

        textFieldA1 = new JTextField(5);
        textFieldB1 = new JTextField(5);
        textFieldC1 = new JTextField(5);

        textFieldA2 = new JTextField(5);
        textFieldB2 = new JTextField(5);
        textFieldC2 = new JTextField(5);

        solveButton = new JButton("Solve");

        labelResult = new JLabel("Result:");
        resultTextField = new JTextField(20);
        resultTextField.setEditable(false);

        // Set layout manager
        setLayout(new GridLayout(5, 2));

        // Add components to the frame
        add(labelEquation1);
        add(new JLabel()); // Empty label for spacing
        add(new JLabel("a1:"));
        add(textFieldA1);
        add(new JLabel("b1:"));
        add(textFieldB1);
        add(new JLabel("c1:"));
        add(textFieldC1);
        add(labelEquation2);
        add(new JLabel()); // Empty label for spacing
        add(new JLabel("a2:"));
        add(textFieldA2);
        add(new JLabel("b2:"));
        add(textFieldB2);
        add(new JLabel("c2:"));
        add(textFieldC2);
        add(new JLabel()); // Empty label for spacing
        add(solveButton);
        add(labelResult);
        add(resultTextField);

        // Add action listener to the solve button
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveLinearSystem();
            }
        });
    }

    private void solveLinearSystem() {
        try {
            double a1 = Double.parseDouble(textFieldA1.getText());
            double b1 = Double.parseDouble(textFieldB1.getText());
            double c1 = Double.parseDouble(textFieldC1.getText());

            double a2 = Double.parseDouble(textFieldA2.getText());
            double b2 = Double.parseDouble(textFieldB2.getText());
            double c2 = Double.parseDouble(textFieldC2.getText());

            double determinant = a1 * b2 - a2 * b1;

            if (determinant != 0) {
                double x = (c1 * b2 - c2 * b1) / determinant;
                double y = (a1 * c2 - a2 * c1) / determinant;
                resultTextField.setText("Solution: x = " + x + ", y = " + y);
            } else {
                resultTextField.setText("No unique solution (determinant is zero)");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinearSystemSolver().setVisible(true);
            }
        });
    }
}
