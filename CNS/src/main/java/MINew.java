import java.util.Scanner;

public class MINew {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Multiplicative Inverse Calculator");

        // Input
        System.out.print("Enter Number: ");
        int number = scanner.nextInt();
        System.out.print("Enter Modulus: ");
        int modulus = scanner.nextInt();

        // Calculate and output result
        int inverse = calculateMultiplicativeInverse(number, modulus);
        if (inverse != -1) {
            System.out.println("Multiplicative Inverse: " + inverse);
        } else {
            System.out.println("No multiplicative inverse (not coprime)");
        }

        scanner.close();
    }

     private static int calculateMultiplicativeInverse(int number, int modulus) {
        int s1 = 1, s2 = 0, t1 = 0, t2 = 1, s = 0, t = 0, r1 = number, r2 = modulus, q, r;

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

        if (r1 == 1) {
            // Ensure the result is positive
            return (s1 % modulus + modulus) % modulus;
        } else {
            return -1; // No multiplicative inverse (not coprime)
        }
    }
}
