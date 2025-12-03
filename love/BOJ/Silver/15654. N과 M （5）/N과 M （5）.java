import java.io.*;
import java.util.*;


public class Main {

	static int N, M;
	static int[] nums;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 총 개수
        M = Integer.parseInt(st.nextToken()); // 최대 문자열 길이 (== depth)
        nums = new int[N];
        visited = new boolean[N];
        answer = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        // Simulation
        dfs(0);

        // Result
        System.out.println(sb.toString());
    }

	private static void dfs(int depth) {
		// 종료조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 점화식
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = nums[i];
				dfs(depth+1);
				visited[i] = false;
				
			}
		}
	}// ... dfs

    

}
