import java.io.*;
import java.util.*;


public class Main {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        // Simulation
        dfs(0);

        // Result
        System.out.println(sb.toString());
    }

	private static void dfs(int depth) {
		// 종료 조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 점화식
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			dfs(depth+1);
		}
	}// ... dfs

    

}
