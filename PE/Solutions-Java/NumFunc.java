import java.util.*;

public class NumFunc{

	//GCD METHOD
	public long gcd (long a , long b){
		if (a < b){
			long c = a;	
			a = b;
			b = c;
		}
		if (b==0){ 
			return a;
		}
		else{
			return gcd(b, a % b);
		}
	}

	//LCM METHOD
	public long lcm (long a, long b){
		ProjectEuler pe = new ProjectEuler();
		long c;
		c = a * b / pe.gcd(a, b);
		return c;
	}

	//WAIT METHOD [S SEC]
	public static void manySec(long s) {
     		try {
       			Thread.currentThread().sleep(s * 1000);
       		}
     		catch (InterruptedException e) {
       			e.printStackTrace();
       		}
     	}

	//MAIN METHOD
	public static void main(String[] args){
		NumFunc a = new NumFunc();
		NumFunc b = new NumFunc();
		Scanner scany;
		String s;
		int d, e, x = 0;
		

		scany = new Scanner( System.in );
		while (x != -1){
	    		System.out.println("Choose option: ");
			System.out.println("1: GCD");
			System.out.println("2: LCM");
			System.out.println("-1: quit");
			x = scany.nextInt();

			if (x == 1){
				System.out.print("Input 2 values separated by a space:");
				d = scany.nextInt();
				e = scany.nextInt();
				System.out.print("GCD: ");
				System.out.println(a.gcd(d,e));
				NumFunc.manySec(1);
			}
			if (x == 2){
				System.out.print("Input 2 values separated by a space:");
				d = scany.nextInt();
				e = scany.nextInt();
				System.out.print("LCM: ");
				System.out.println(a.lcm(d,e));
				NumFunc.manySec(1);
			}
		}
	}
}
