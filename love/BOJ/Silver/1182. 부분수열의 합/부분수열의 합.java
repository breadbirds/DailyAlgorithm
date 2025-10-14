import java.io.*;
import java.util.*;


/**
 * 
 * 문제 읽기
 * - N 개의 정수로 이루어진 수열 주어짐.
 * - 크기가 양수인 부분 수열 중, 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 * 
 * - 크기가 양수라는건.. 그냥 0개 이상 포함해라는 의미(양수로 이루어진 수 x)
 * 
 */
public class Main {

	static int N, S, answer;
	static int[] arr;
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
    	
    	// init & input
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	S = sc.nextInt(); // 목표 수
    	arr = new int[N];
    	visited = new boolean[N];
    	answer = 0;
    	
    	for(int i=0; i<N; i++) {
    		arr[i] = sc.nextInt();
    	}

    	// Simulation
    	dfs(0, 0);
    	
    	// 공집합 제외 : 목표값이 0인 경우, 최종 결과가 sum = 0 이 되는데 아무것도 선택하지 않고 끝까지 가는 경우 sum 값도 0이므로 이는 잘못된 계산이므로 뺴준다 !
        if(S == 0) answer--;
    	
    	// Result
    	System.out.println(answer);
    }

	private static void dfs(int idx, int sum) {
		
		// 종료조건
		if(idx == N) {
			if(sum == S) answer++;
			return;
		}
		
		
		// 탐색
		// 현재 원소 선택
        dfs(idx+1, sum + arr[idx]);
        
        // 현재 원소 미선택
        dfs(idx+1, sum);
		
	}
}
