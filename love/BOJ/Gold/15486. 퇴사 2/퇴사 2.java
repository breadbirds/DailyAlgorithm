import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] t = new int[N];
    	int[] p = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		t[i] = Integer.parseInt(st.nextToken());
    		p[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	long[] dp = new long[N + 2]; // day N까지 +1 더 필요
    	
    	for (int day = 0; day < N; day++) {
    		// 1. 오늘 일을 하지 않고 넘긴 경우 → dp[day + 1]에 현재 값 전달
    		dp[day + 1] = Math.max(dp[day + 1], dp[day]);
    		
    		// 2. 오늘 상담하는 경우
    		if (day + t[day] <= N) {
    			dp[day + t[day]] = Math.max(dp[day + t[day]], dp[day] + p[day]);
    		}
    	}
    	
    	System.out.println(dp[N]);
    }
}
