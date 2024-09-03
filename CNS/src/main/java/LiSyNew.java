import java.util.Scanner;

public class LiSyNew {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Linear System Solver");

        System.out.println("Enter coefficients for Equation 1 (a1x + b1y = c1):");
        System.out.print("a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("c1: ");
        double c1 = scanner.nextDouble();

        System.out.println("Enter coefficients for Equation 2 (a2x + b2y = c2):");
        System.out.print("a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("c2: ");
        double c2 = scanner.nextDouble();

        double determinant = a1 * b2 - a2 * b1;

        if (determinant != 0) {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            System.out.println("Solution: x = " + x + ", y = " + y);
        } else {
            System.out.println("No unique solution (determinant is zero)");
        }

        scanner.close();
    }
}
