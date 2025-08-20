import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - 축구를 하기 위해 모인 사람 N 명(짝수), N/2 명으로 이루어진 '스타트 팀' 과 '링크 팀'을 나눠야 한다.
 * - 각 사람에게 번호를 1번부터 N까지 배정
 * - 능력치 조사 : Sij 는 i 번 사람과 j 번 사람이 같은 팀에 속했을 때 더해지는 능력치
 * 				팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합
 * 				Sij 는 Sji와 다를 수 있음
 * 				i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji
 * - 팀의 능력치 차이 최소화 값을 구하여라
 * 
 */
public class Main {

	public static int N, answer;
	public static int[][] ability;
	public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // init & input
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		ability[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // Simulation
        /**
         * 무조건 팀은 2개로 나뉘어지니까 각각을 담을 배열 변수를 생성
         * teamA, teamB, 인원을 중복으로 넣지 않기 위해 visited 생성
         * 
         * teamA에 넣고 방문처리(현재까지 합계 들고), 인덱스끝까지가면 검사, 취소하고 teamB에 넣기
         * 
         * 
         */
        
        dfs(0, 0);
        
        
        // Result
        System.out.println(answer);
        
        
        

    }// ...main

    
	private static void dfs(int start, int cnt) {
		
		// 중단조건 : N/2명 완성되면
		if(cnt == N/2) {
			answer = Math.min(answer,  diff());
			return;
		}
		
		// dfs 를 이용해서 N명중에 N/2명만 A팀에 넣는 조합을 만든다.
		
		// 모든 사람(N명)을 다 확인했으면 더 이상 탐색하지 않음
		if(start == N) return;
		
		// need : 앞으로 A팀에 더 뽑아야 하는 인원 수
		// cnt : 지금까지 A팀에 넣은 인원 수
		// left : 아직 살펴보지 않은 사람 수
		int need = N/2 - cnt; 
		int left = N - start;
		
		// 남은 사람으로 A팀 인원을 다 채울 수 없는 경우 의미 없는 탐색이므로 중단
		if(left < need) return;

		// i번재 사람을 A팀에 넣고, 다음 사람 탐색을 위한 재귀 (이후 선택 취소) 반복
		for(int i=start; i<N; i++) {
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
		
	}


	private static int diff() {
		int a = 0;
		int b = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				
				// 둘다 A인 경우
				if(visited[i] && visited[j]) {
					a += ability[i][j] + ability[j][i];
				} 
				// 둘다 B인 경우
				else if(!visited[i] && !visited[j]) {
					b += ability[i][j] + ability[j][i];
				}
			}
		}
		
		return Math.abs(a - b);
	}
    
 

}
