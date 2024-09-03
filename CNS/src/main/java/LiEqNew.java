import java.util.Scanner;

public class LiEqNew {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Linear Equation Solver");

        System.out.print("Enter Coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter Coefficient b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double solution = -b / a;
            System.out.println("Solution: x = " + solution);
        } else {
            System.out.println("No solution (a cannot be zero)");
        }

        scanner.close();
    }
}
