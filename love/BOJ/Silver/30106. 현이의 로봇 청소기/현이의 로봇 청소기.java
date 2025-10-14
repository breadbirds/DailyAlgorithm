import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] grid;
    static boolean[][] visited;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static void bfs(int sx, int sy){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.add(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int h = grid[x][y];

            for(int d=0; d<4; d++){
                int nx = x + dx[d], ny = y + dy[d];
                if(!inRange(nx, ny) || visited[nx][ny]) continue;

                int nh = grid[nx][ny];
                // |h - nh| <= K ↔ nh ∈ [h - K, h + K]
                if (nh < h - K || nh > h + K) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int components = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    components++;
                }
            }
        }
        System.out.println(components);
    }
}
