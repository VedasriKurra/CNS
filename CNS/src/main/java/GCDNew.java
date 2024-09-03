import java.util.Scanner;
public class GCDNew {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a,b;
		System.out.println("Enter a:");
		a=sc.nextInt();
		System.out.println("Enter b:");
		b=sc.nextInt();
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
		System.out.println("gcd:"+r1);
	}
}
