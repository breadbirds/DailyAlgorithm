import java.util.Scanner;
import java.util.*;

class Main{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println(A+B-C);
		System.out.println(Integer.parseInt(A+""+B) - C);
	}
	
}