import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 맵의 크기 N * M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		// 입력값 받기
		for(int i=0; i<N; i++) {
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
		    String line = br.readLine(); // 공백 없이 한 줄 입력
			for(int j=0; j<M; j++) {
		        arr[i][j] = line.charAt(j) - '0'; // 문자 → 숫자 변환
			}
		}
		
		
		// bfs 연산 수행
		bfs(new Point(0,0));
		
		
		// 출력 : (N, M) 까지 도달하는데 걸린 거리
		System.out.println(arr[N-1][M-1]);
	}


	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void bfs(Point point) {
		Queue<Point> que = new LinkedList<Point>(); 
		que.add(new Point(point.x, point.y));
		visit[point.x][point.y] = true;
		
		while(!que.isEmpty()) {
			Point current = que.poll();
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				// 맵을 벗어나는 경우, 이미 방문 한 경우, 벽에 가로막힌 경우 탐색 불가 
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[nx][ny] == 0) continue;
				
				
				// 탐색 가능 한 경우!
				arr[nx][ny] = arr[current.x][current.y]+1;
				visit[nx][ny] = true;
				que.add(new Point(nx, ny));
			}
		}
		
	}
	

}