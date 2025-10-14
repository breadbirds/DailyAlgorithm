import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - N*M 격자, 각 칸은 육지(L) or 바다(W) 로 표시
 * - 상하좌우 이웃한 육지로만 이동 가능, 한 칸 이동하는데 '한 시간'
 * - 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
 * 	 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
 */

public class Main {
	
	static int N, M, answer;
	static char[][] map;
	static char W = 'W';
	static char L = 'L';
	
	static int[] dxs = {-1, 0, 1, 0};
	static int[] dys = {0, 1, 0, -1};
	
	static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}
	
    public static void main(String[] args) throws IOException {
    	// init & input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];
    	answer = 0;
    	
    	for(int i=0; i<N; i++) {
    		String line = br.readLine();
    		for(int j=0; j<M; j++) {
    			map[i][j] = line.charAt(j);
    		}
    	}
    	
    	// Simulation
    	 for (int i = 0; i < N; i++) {
             for (int j = 0; j < M; j++) {
                 if (map[i][j] == L) {
                     answer = Math.max(answer, bfs(i, j));
                 }
             }
         }
    	
    	
    	// Result
    	System.out.println(answer);
    }
    
    static int bfs(int sx, int sy) {
        // sx, sy는 반드시 L에서만 호출
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;

        int far = 0; // 이 시작점에서의 최장 최단거리

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            far = Math.max(far, dist[x][y]);

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dxs[dir];
                int ny = y + dys[dir];
                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] == W) continue;
                if (dist[nx][ny] != -1) continue; // 이미 방문

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return far;
    }
}