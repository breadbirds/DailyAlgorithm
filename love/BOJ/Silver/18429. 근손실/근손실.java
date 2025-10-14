import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	// 하루가 지날 때 마다 중량이 K 만큼 감소
	
	static int n, k;
	static int ans;
	static int[] weight;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		n = Integer.parseInt(nk[0]); // 운동 키트 수
		k = Integer.parseInt(nk[1]); // 하루에 감소하는 중량
		
		String[] arr = br.readLine().split(" ");
		weight = new int[n];
		visited = new boolean[n+1];
		for(int i=0; i<n; i++) weight[i] = Integer.parseInt(arr[i]);
		
		// 계산
		
		
		// 출력: 운동 기간동안 중량이 500이상 되도록 하는 경우의 수
		dfs(0, 500);
		System.out.println(ans);
		
		
	}

	
	
	private static void dfs(int i, int w) {
		
		if(w < 500) return;
		
		if(i == n) {
			ans += 1;
			return;
		}
		
		w -= k;
		for(int j=0; j<n; j++) {
			if(visited[j]) continue;
			
			visited[j] = true;
			dfs(i+1, w+weight[j]);
			visited[j] = false;
		}
		
	}

}