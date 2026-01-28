package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304_20250618 {
	public static void main(String[] args) throws IOException {
		// 영수증 총금액 X
		// 영수증 구매한 물건 종류 N
		// 물건 가격 a, 개수 b
		// 총금액==영수증금액 Yes, 총금액!=영수증금액 No
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int X, N, a, b;
		int total = 0;
		
		X=Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			total += a*b;
			
		}
		if(X == total) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		// System.out.println(X == total? "Yes" : "No");
		
				
				
	}

}
