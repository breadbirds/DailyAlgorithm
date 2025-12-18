import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, C;
	
	public static void main(String[] args) throws Exception {
		
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		// Simulation : N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지?
		long answer = solve(B);
	
		// Result
		System.out.println(answer);
	}

	private static long solve(long b) {
		if(b == 0) return 1;
		
		long temp = solve(b/2);
		temp = (temp * temp) % C;
		
		if (b % 2 == 1) {
			temp = (temp * A) % C;
		}
		
		return temp;
	}


}
