import java.io.*;
import java.util.*;

public class Main {
	
	static int N, r, c;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		// Simulation : N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지?
		answer = 0;
		
		solve((int)Math.pow(2, N)); // == 2^N
	
		// Result
		System.out.println(answer);
	}


	private static void solve(int size) {
		
		// 끝나는 조건 : (r, c)에 도달 했을 때
		if(size == 1) return;
		
		int half = size/2;		// 정사각형등분 (사분면의 한 변 길이의미) 
		int block = half*half;	// 사분면 하나에 들어있는 칸의 수
		
		
		// 1. 사분면 판단 + 좌표 기준 맞추기·갱신
		if(r < half && c < half) {
			// 1분면
			//answer += 0;
		}else if(r < half && c >= half) {
			// 2분면
			answer += block;
			c -= half;
		}else if(r >= half && c < half) {
			// 3분면
			answer += block*2;
			r -= half;
		}else {
			// 4분면 
			answer += block*3;
			c -= half;
			r -= half;
		}
		
		
		solve(half);
	}
}
