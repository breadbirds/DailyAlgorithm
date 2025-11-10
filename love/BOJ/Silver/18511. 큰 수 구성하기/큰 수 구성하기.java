import java.io.*;
import java.util.*;


/**
 * [문제 읽기]
 * - N보다 작거나 같은 자연수중, 집합 K 의 원소로만 구성된 가장 큰 수를 출력하는 프로그램 작성
 * - K의 모든 원소는 1부터 9까지의 자연수로만 구성
 */
public class Main {
	
	public static int N, K;
	public static int answer = 0;
	public static int[] nums;
	
    public static void main(String[] args) throws IOException {
    	// input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	nums = new int[K];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<K; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	// Simulation
    	Arrays.sort(nums);
    	dfs(0);
    	
    	
    	// Result
    	System.out.println(answer);
    }

	private static void dfs(int current) {
		
		// 종료조건
		if(current > N) return;
		
		// 정답 갱신
		answer = Math.max(answer, current);
		
		// 재귀
		for(int i=0; i<K; i++) {
			dfs(current * 10 + nums[i]);
		}
		
	}

}