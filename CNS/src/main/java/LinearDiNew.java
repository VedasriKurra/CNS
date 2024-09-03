import java.util.Scanner;
public class LinearDiNew{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a:");
		int a=sc.nextInt();
		System.out.println("enter b:");
		int b=sc.nextInt();
		System.out.println("enter c:");
		int c=sc.nextInt();
		int[] result = solveLinearDiophantineEquation(a, b, c);
        System.out.println("Particular Solution: x = " + result[1] + ", y = " + result[2] +
                    "\nGeneral Solution: x = " + result[1] + " + " + (b / result[0]) + "t, y = " +
                    result[2] + " - " + (a / result[0]) + "t");
	}
	private static int[] solveLinearDiophantineEquation(int a, int b, int c) {
		int[] gcdResult = extendedGCD(a, b);

        if (c % gcdResult[0] == 0) {
            int x0 = gcdResult[1] * (c / gcdResult[0]);
            int y0 = gcdResult[2] * (c / gcdResult[0]);
            return new int[]{gcdResult[0], x0, y0};
        } else {
            return new int[]{1, 0, 0}; // No solution
        }
	}
	private static int[] extendedGCD(int a, int b) {
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

}