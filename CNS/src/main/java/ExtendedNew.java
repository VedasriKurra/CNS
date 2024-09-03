import java.util.Scanner;
public class ExtendedNew {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a,b;
		System.out.println("Enter a:");
		a=sc.nextInt();
		System.out.println("Enter b:");
		b=sc.nextInt();
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
	            t=t1-q*t2;
	            s=s1-q*s2;
	            s1=s2;
	            s2=s;
	            t1=t2;
	            t2=t;
	        }
		System.out.println("gcd:"+r1+"s:"+s1+"t:"+t1);
	}
}
