package Algo;

import java.util.Scanner;

public class BOJ_31403_20250623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int c = sc.nextInt();
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		
		System.out.println(Integer.parseInt(a)+ Integer.parseInt(b) - Integer.parseInt(c));
		System.out.println(Integer.parseInt(a + b) - Integer.parseInt(c));
		
				
	}

}
