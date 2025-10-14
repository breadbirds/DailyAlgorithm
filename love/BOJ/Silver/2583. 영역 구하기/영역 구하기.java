import java.io.*;
import java.util.*;

/**
 * 문제 읽기 : https://www.acmicpc.net/problem/2583
 * 
 * - M * N 격자, 눈금에 맞추어 K 개의 직사각형 그리기
 * - 직사각형 영역을 제외한 나머지 부분에 대한 것 구하기
 *    나머지 영역은 총 몇개인지, 각 영영의 넓이는?
 */
class Main {
    
    static int N, M, K;
    static int[][] grid;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];
        
        // K 번 반복 : 영역 색칠하기
        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 영역 색칠하기
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    grid[y][x] = 1; // y가 행, x가 열
                }
            }
            
        }
        
        // 빈칸영역 찾기
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        
        // Result
        Collections.sort(list);
        System.out.println(cnt);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }// ...main
    
    static int[] dxs = {-1, 0, 1, 0};
    static int[] dys = {0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }

    public static class Node{

        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        
        int group = 1;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dxs[i];
                int ny = cur.y + dys[i];
                
                if(!inRange(nx, ny) || grid[nx][ny] != 0 || visited[nx][ny]) continue;
                
                group++;
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }
            
        }
        
        return group;
    }
}