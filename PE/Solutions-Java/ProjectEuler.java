import java.util.*;

public class ProjectEuler {
	int sum;
	int product;


//================================FUNCTION METHODS==========================================

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
	//Nth PRIME METHOD
	public long prime(int a){
		long[] primeholder;
		primeholder = new long[a];
		primeholder[0] = 2;
		int i = 1;
		for(int b = 3; i < a; b+=2){
			boolean prime = true;
			for(int j = 0; j < i; j++){
				if (b % primeholder[j] == 0){
					prime = false;
				}
			}
			if (prime == true){
				primeholder[i] = b;
				i++;
			}
		}
		return primeholder[a-1];
	}

//================================PROBLEM METHODS==========================================


	//PROBLEM 2
	public void p2(int a, int b){//sum of even Fibonaccis
		int c;
		while (b < 4000000){
			if (b % 2 == 0){
				sum+=b;
			}
		c = b;
		b+=a;
		a = c;
		}
	System.out.println(sum);
	}

	//PROBLEM 4
	public void p4(int a, int b){
		int c, d, e;
		c = a;
		d = b;
		e = 0;
		for(int i = 0; b < 1000; b+=11){
			a = c;
			while (a < 1000){		
				e = a * b;
				if (Math.floor(e / Math.pow(10, 5)) == e % 10 && Math.floor(e / Math.pow(10, 4)) % 10 == Math.floor(e / Math.pow(10, 1)) % 10 && Math.floor(e / Math.pow(10, 3)) % 10 == Math.floor(e / Math.pow(10, 2)) % 10 && e > product){
					product = a * b;
				}
				a++;
			}
		}
	System.out.println(product);
	}	
	
	//PROBLEM 5
	public void p5(int a){
		long answer = 1;
		for(int i = 1; i < a + 1; i++){
			answer = lcm(answer, i);
		}
		System.out.println(answer);
	}

	//PROBLEM 6
	public void p6(int a){
		long sumofsquares = 0;
		long squareofsum = 0;
		long sums = 0;
		long answer;
		for (int i = 1; i < a + 1; i++){
			sumofsquares = sumofsquares + i*i;
		}
		for (int i = 1; i < a + 1; i++){
			sums = sums + i;
		}
		squareofsum = sums * sums;
		answer = Math.abs(sumofsquares - squareofsum);
		System.out.println(answer);
	}

	//PROBLEM 7
	public void p7(){
		ProjectEuler pe = new ProjectEuler();
		long answer;
		answer = pe.prime(10001);
		System.out.println(answer);
	}
/*
	//PROBLEM 8
	public void p8(){
		ProjectEuler pe = new ProjectEuler();
		String longthing = pe.readString(); //inputted string
		long answer;
		String[] digitholder;
		digitholder = new String[5];
		for(int i = 0; i < longthing.length() - 5; i++){
			for(int j = 0; j < 5; j++){
				digitholder[j] = longthing.length(i, i+5);
			}			
			
		}
*/
	//PROBLEM 9

	public static void main(String[]args){
		ProjectEuler solutioner = new ProjectEuler();
	//	solutioner.p2(1,1);
	//	solutioner.p4(506,506);
	//	solutioner.p5(20);
	//	solutioner.p6(100);
	//	solutioner.p7();
	}

}
