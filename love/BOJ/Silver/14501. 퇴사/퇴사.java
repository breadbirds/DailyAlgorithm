import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - 백준이는 퇴사를 할꺼다!
 * - 퇴사전 남은 N일동안 최대한 많은 상담을 하려고 함
 * 하루에 하나씩 서로다른 사람의 상담을 잡음
 * 상담걸리는 기간 T, 상담했을 때 받을 수 있는금액 P
 * 
 * 모든 상담을 다 할수는 없음. 예를 들어 1일차에 3일이 걸리는 상담(T = 3)을 시작하면, 2일차-3일차에는 상담업무를 할 수 없음.
 * N(= 퇴사날) 일 에도 업무 불가능
 * 
 * 상담을 했을 때 최대의 수익을 얻을 수 있는 프로그램 작성하기
 */
public class Main {
	
	public static int N;
	public static int[] t;
	public static int[] p;
	public static int answer;
	public static int result;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 퇴사 날짜
		
		t = new int[N];
		p = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 계산
		dfs(0, 0);
		
		
		// 결과
		System.out.print(result);

	}

	private static void dfs(int day, int sum) {
		
		// 종료조건
		if(day >= N) {
	        // 퇴사일을 넘었거나 딱 맞춘 경우: 정산이 가능할때만 정답을 갱신 !
	        if(day == N) result = Math.max(result, sum);
	        return;
	    }
		
		 // 상담을 하는 경우
	    if(day + t[day] <= N) dfs(day + t[day], sum + p[day]);
	    
	    // 상담을 안 하고 넘어가는 경우
	    dfs(day + 1, sum);
		
	}
}
