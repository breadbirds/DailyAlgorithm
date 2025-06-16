package Algo;

import java.util.Scanner;

public class BOJ_2420_20250616 {
	public static void main(String[] args) {
		long N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		long answer = N-M;
		if(answer < 0 ) {
			System.out.println(-answer);
		}
		else {
			System.out.println(answer);
		}
	}

}
