import java.io.*;
import java.util.*;



public class Main {

	static int N, M;
	static int[] nums;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 문자 수
    	M = Integer.parseInt(st.nextToken()); // 길이
    	nums = new int[N];
    	visited = new boolean[N];
    	answer = new int[M];
    
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
    	// Simulation
    	dfs(0, 0);

    	// Result
    	System.out.println(sb.toString());
    }

    
	private static void dfs(int start, int depth) {
		
		// 종료 조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 점화식
		int prev = -1;
		for(int i=start; i<N; i++) {
			if(!visited[i] && prev != nums[i]) {
				prev = nums[i];
				
				visited[i] = true;
				answer[depth] = nums[i];
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}

		
	}
}
