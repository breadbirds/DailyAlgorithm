import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 

class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N;
	static int[][] arr;
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visit;


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		// 입력값 받기
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				int temp = line.charAt(j) - '0';
				arr[i][j] = temp;
			}
		}
		
		// 탐색 시작?
		// 모든 칸을 돌면서 dfs 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    count = 0; // 새로운 단지 시작
                    dfs(i, j);
                    result.add(count); // 단지 크기 저장
                }
            }
        }

		
		
		// 결과물 출력
		 Collections.sort(result);
	     System.out.println(result.size());
		 for (int count : result) {
	            System.out.println(count);
	        }
	}


    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

	private static void dfs(int x, int y) {
		visit[x][y] = true;
        count++; // 현재 집 포함
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 밖 or 방문했거나 0인 경우는 패스
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visit[nx][ny] || arr[nx][ny] == 0) continue;

            dfs(nx, ny); // 연결된 집으로 재귀
        }
        
		
	}



	

}