import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinearEquationSolver extends JFrame {

    private JLabel labelCoefficientA, labelCoefficientB, labelResult;
    private JTextField textFieldCoefficientA, textFieldCoefficientB, resultTextField;
    private JButton solveButton;

    public LinearEquationSolver() {
        setTitle("Linear Equation Solver");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        labelCoefficientA = new JLabel("Enter Coefficient a:");
        labelCoefficientB = new JLabel("Enter Coefficient b:");

        textFieldCoefficientA = new JTextField(10);
        textFieldCoefficientB = new JTextField(10);

        solveButton = new JButton("Solve");

        labelResult = new JLabel("Result:");
        resultTextField = new JTextField(20);
        resultTextField.setEditable(false);

        // Set layout manager
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(labelCoefficientA);
        add(textFieldCoefficientA);
        add(labelCoefficientB);
        add(textFieldCoefficientB);
        add(new JLabel()); // Empty label for spacing
        add(solveButton);
        add(labelResult);
        add(resultTextField);

        // Add action listener to the solve button
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveLinearEquation();
            }
        });
    }

    private void solveLinearEquation() {
        try {
            double a = Double.parseDouble(textFieldCoefficientA.getText());
            double b = Double.parseDouble(textFieldCoefficientB.getText());

            if (a != 0) {
                double solution = -b / a;
                resultTextField.setText("Solution: x = " + solution);
            } else {
                resultTextField.setText("No solution (a cannot be zero)");
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
                new LinearEquationSolver().setVisible(true);
            }
        });
    }
}