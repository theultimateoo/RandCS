import java.util.*;
import java.math.*;
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
  
  //PRINTNUMBER METHOD (STRING VER)
  public void numberPrinter(){
    String n = "0123456789";
    for(int i = 0; i < n.length(); i++){
      System.out.print((int)n.charAt(i) - 48);
    }
  }
  
  //isPrime?!?!?!?!?!?!?!
  public boolean isPrime(int n){
    if (n == 1)
      return false;
    if (n < 4)
      return true;
    if (n % 2 == 0)
      return false;
    if (n < 9)
      return true;
    if (n % 3 == 0)
      return false;
    double r = Math.floor(Math.sqrt(n));
    int f = 5;
    while (f <= r){
      if (n % f == 0)
        return false;
      if (n % (f + 2) == 0)
        return false;
      f+=6;
    }
    return true;
  }
  
  //DIVISOR COUNTER
  public int numDivis(int a){
    int number = a;
    int divisor = 2;
    int[] primeholder = new int[100];
    int[] primepower = new int[100];
    int primeholderpos = 0;
    int primepowerpos = 0;
    while(number > 1){
      if(isPrime(divisor) == true){
        if(number % divisor == 0){
          primeholder[primeholderpos] = divisor;
          primepower[primepowerpos]++;
          number = number / divisor;
        }
        else{
          primeholderpos++;//there is a problem that it adds for nonprimes as well
          primepowerpos++;
          divisor++;
        }
      }
      else{
        divisor++;
      }
    }
    int answer = 1;
    for(int i = 0; i < primepower.length; i++){
      answer = answer * primepower[i];
    }
    return answer;
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
  
  //PROBLEM 8
  public void p8(){
    String number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
    long answer = 1;
    long fakeans = 1;
    for(int i = 0; i < number.length() - 5; i++){
      for(int j = i; j < i + 5; j++){
        fakeans = fakeans * ((int)number.charAt(j) - 48);
      }   
      if(fakeans > answer){
        answer = fakeans;
      }
      fakeans = 1; 
    }
    System.out.println(answer);
  }
  
  //PROBLEM 9
  public void p9(){
    boolean gotAns = false;
    for(int b = 100; gotAns == false; b++){
      for(int a = 100; a < b; a++){
        int c = 1000 - a - b;
        if(a * a + b * b == c * c){
          gotAns = true;
          System.out.println(a * b * c);
        }
      }
    }
  }
  
  //PROBLEM 10
  public void p10(){
    ProjectEuler pe = new ProjectEuler();
    long answer = 0;
    for(int i = 1; i < 2000000; i++){
      if (pe.isPrime(i) == true)
        answer = answer + i;
    }
    System.out.println(answer);
  }
  
  //PROBLEM 11
  public void p11(){
    int[][] array = {{8,02,22,97,38,15,00,40,00,75,04,05,07,78,52,12,50,77,91,8},
      {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00},
      {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65},
      {52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91},
      {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
      {24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50},
      {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
      {67,26,20,68,02,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
      {24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
      {21,36,23,9,75,00,76,44,20,45,35,14,00,61,33,97,34,31,33,95},
      {78,17,53,28,22,75,31,67,15,94,03,80,04,62,16,14,9,53,56,92},
      {16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57},
      {86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58},
      {19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40},
      {04,52,8,83,97,35,99,16,07,97,57,32,16,26,26,79,33,27,98,66},
      {88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69},
      {04,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
      {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16},
      {20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54},
      {01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48}};
    long answer = 0; 
    int fakeans = 0;
    for(int i = 0; i < array.length - 4; i++){
      for(int j = 0; j < array[0].length; j++){
        fakeans = array[i][j] * array[i+1][j] * array[i+2][j] * array[i+3][j];
        if (fakeans > answer)
          answer = fakeans;
      }
    }
    for(int j = 0; j < array[0].length - 4; j++){
      for(int i = 0; i < array.length; i++){
        fakeans = array[i][j] * array[i][j+1] * array[i][j+2] * array[i][j+3];
        if (fakeans > answer)
          answer = fakeans;
      }
    }
    for(int i = 0; i < array.length - 4; i++){
      for(int j = 0; j < array[0].length - 4; j++){
        fakeans = array[i][j] * array[i+1][j+1] * array[i+2][j+2] * array[i+3][j+3];
        if (fakeans > answer)
          answer = fakeans;
      }
    }
    for(int i = 0; i < array.length - 4; i++){
      for(int j = 4; j < array[0].length; j++){
        fakeans = array[i][j] * array[i+1][j-1] * array[i+2][j-2] * array[i+3][j-3];
        if (fakeans > answer)
          answer = fakeans;
      }
    }
    System.out.println(answer);
  }
  
  //PROBLEM 12
  public void p12(){
    int tri = 1;
    boolean gotAns = false;
    for(int j = 2; gotAns == false; j++){
      if(numDivis(tri) > 500){
        gotAns = true;
        System.out.println(numDivis(tri));
      }
      tri = tri + j;
    }
  } 
  
  //PROBLEM 13
  public void p13(){
    BigInteger array[] = new BigInteger[100];
    Scanner scany = new Scanner(System.in);
    for(int i = 0; i < 100; i++){
      array[i] = scany.nextBigInteger();
    }
    BigInteger pe = new BigInteger("0");
    for(int i = 0; i < 100; i++){
      pe = pe.add(array[i]);
    }
    String n = pe.toString();
    System.out.println(n);
    String answer = n.substring(0,10);
    System.out.println(answer);
  }
  //PROBLEM 15
  public void p15(){
    BigInteger fact = new BigInteger("40");
    BigInteger fact2 = new BigInteger("40");
    BigInteger a = new BigInteger("20");
    BigInteger b = new BigInteger("20");
    BigInteger one = new BigInteger("1");
    while (fact2.compareTo(one) == 1){
      fact = fact.multiply(fact2.subtract(one));
      fact2 = fact2.subtract(one);
    }
    while (b.compareTo(one) == 1){
      a = a.multiply(b.subtract(one));
      b = b.subtract(one);
    }
    fact = fact.divide(a);
    fact = fact.divide(a);
    String n = fact.toString();
    System.out.println(n);
  }
  
  //PROBLEM 16
  public void p16(){
    BigInteger two = new BigInteger("2");
    BigInteger pe = two.pow(1000);
    String n = pe.toString();
    int answer = 0;
    for (int i = 0; i < n.length(); i++) {
      answer = answer + (int)n.charAt(i) - 48;
    }
    System.out.println(answer);
  }
  //PROBLEM 17
  public void p17(){
	int count = 0;
	//one, two, six, nine, four, five, seven, three, eight 
	
	for(int i = 1; i < 1000; i++){
		if(i > 100 && i % 100 != 0){
			count+=3;
		}
		if(i % 100 > 9  && i % 100 < 20){
			if(i % 100 == 10){//ten
				count+=3;
			}
			else if(i % 100 == 11 || i % 100 == 12){//eleven, twelve
				count+=6;
			}
			else if(i % 100 == 13 || i % 100 == 14 || i % 100 == 18 || i % 100 == 19){//thirteen, fourteen, eighteen, nineteen
				count+=8;
			}
			else if(i % 100 == 15 || i % 100 == 16){//fifteen, sixteen
				count+=7;
			}
			else if(i % 100 == 17){
				count+=9;
			}
		}
		//Singles place		
		if((i % 10 == 1 || i % 10 == 2 || i % 10 == 6) && (i % 100 < 10 || i % 100 > 19)){
			count+=3;
		}
		if((i % 10 == 4 || i % 10 == 5 || i % 10 == 9) && (i % 100 < 10 || i % 100 > 19)){
			count+=4;
		}
		if((i % 10 == 3 || i % 10 == 7 || i % 10 == 8) && (i % 100 < 10 || i % 100 > 19)){
			count+=5;
		}
		//Tens place
		if(Math.floor(i/10) % 10 == 2 || Math.floor(i/10) % 10 == 3 || Math.floor(i/10) % 10 == 8 || Math.floor(i/10) % 10 == 9){
			count+=6;
		}
		if(Math.floor(i/10) % 10 == 4 || Math.floor(i/10) % 10 == 5 || Math.floor(i/10) % 10 == 6){
			count+=5;
		}
		if(Math.floor(i/10) % 10 == 7){
			count+=7;
		}
		//Hundreds place
		if(i < 300 && i > 99){
			count+=3;
		}
		if(i > 299 && i < 400){
			count+=5;
		}
		if(i > 399 && i < 600){
			count+=4;
		} 
		if(i > 599 && i < 700){
			count+=3;
		}
		if(i > 699 && i < 900){
			count+=5;
		}
		if(i > 899 && i < 1000){
			count+=4;
		}
	}
		count+=11;
		count+=(900*7);
		System.out.println(count);
		}
  //PROBLEM 19
  public void p19(){
    int month; // 1 = January
    int year;
    int day = 1; // 0 = Sunday
    int ans = 0;
    for(year = 1901; year < 2000; year++){
      for(month = 1; month < 13; month++){
        if(month == 2 && year % 4 == 0){
          day+=29;
        }
        else if(month == 2){
          day+=28;
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
          day+=30;
        }
        else{
          day+=31;
        }
        day = day % 7;
        if (day == 0){
          ans++;
        }
      }   
    }
    System.out.println(ans);
  }  
  //PROBLEM 20
  public void p20(){
    BigInteger fact = new BigInteger("100");
    BigInteger fact2 = new BigInteger("100");
    BigInteger one = new BigInteger("1");
    while (fact2.compareTo(one) == 1){
      fact = fact.multiply(fact2.subtract(one));
      fact2 = fact2.subtract(one);
    }
    String n = fact.toString();
    int answer = 0;
    for (int i = 0; i < n.length(); i++){
      answer = answer + (int)n.charAt(i) - 48;
    }
    System.out.println(answer);
  }
  
  
  
  //PROBLEM 25
  public void p25(){
    BigInteger dummy = new BigInteger("1");
    BigInteger fibone = new BigInteger("1");
    BigInteger fibtwo = new BigInteger("2");
    BigInteger ten = new BigInteger("10");
    BigInteger tenten = ten.pow(999);
    int i = 3;
    while(fibtwo.compareTo(tenten) == -1){
      i++;
      dummy = fibtwo;
      fibtwo = fibtwo.add(fibone);
      fibone = dummy;
    }
    System.out.println(i);
  }
  
  //PROBLEM 48
  public void p48(){
    BigInteger dummy = new BigInteger("1");
    BigInteger ten = new BigInteger("10000000000");
    BigInteger one = new BigInteger("1");
    BigInteger pe = new BigInteger("0");
    for(int i = 1; i < 1000; i++){
      pe = pe.add(dummy.modPow(dummy, ten));
      dummy = dummy.add(one);
    }
    String n = pe.toString();
    String answer = n.substring(n.length()-10,n.length());
    System.out.println(answer);
  }
  
  public static void main(String[]args){
    ProjectEuler solutioner = new ProjectEuler();
    // solutioner.p2(1,1);
    // solutioner.p4(506,506);
    // solutioner.p5(20);
    // solutioner.p6(100);
    // solutioner.p7();
    // solutioner.p8();
    // solutioner.p9();
    // solutioner.p10();
    // solutioner.p11();
    // solutioner.p12();
    // solutioner.p13();
    // solutioner.p15();
    // solutioner.p16();
	solutioner.p17();
    // solutioner.p19();
    // solutioner.p20();
    // solutioner.p25();
    // solutioner.p48();
  }
  
}
