import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * W*h 사이즈의 격자(섬), 섬(1), 바다(0)
 * 
 * 상하좌우 혹은 대각선으로 이동가능한 경우 => 하나의 섬으로 인식
 * 총 몇개의 섬이 존재하는가를 찾는 문제
 */

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int row, col;
        
        Node(int row, int col){ 
        	this.row = row; 
        	this.col = col; 
        }
    }

    static int W, H;
    static int[][] grid;
    static boolean[][] visited;

    // 8방향 (상하좌우 + 대각선)
    static int[] dRow = {-1,-1,-1, 0, 0, 1, 1, 1};
    static int[] dCol = {-1, 0, 1,-1, 1,-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
        	
        	// 입력값이 아무것도 없을 경우 while 문 입력받기 중단
            String line = br.readLine();
            if (line == null) break;
            
            // 공백 제거 후, 다시 검사
            line = line.trim();
            if (line.isEmpty()) 
            	continue;

            // 문제 없을 경우 input 수행
            StringTokenizer st = new StringTokenizer(line);
            W = Integer.parseInt(st.nextToken()); // 열
            H = Integer.parseInt(st.nextToken()); // 행
            
            // 종료조건 : 입력값이 0, 0 인경우
            if (W == 0 && H == 0) break;
            

            // 배열들 초기화
            grid = new int[H][W];
            visited = new boolean[H][W];

            // 격자 사이즈 입력 받기
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 방문가능한 위치만 bfs 탐색 진행(정답 +1)
            int answer = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        answer++;
                    }
                }
            }
            
            System.out.println(answer);
        }
    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < H && 0 <= col && col < W;
    }

    static void bfs(int sr, int sc) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new Node(sr, sc));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int d = 0; d < 8; d++) {
                int nr = cur.row + dRow[d];
                int nc = cur.col + dCol[d];
                
                // 탐색 불가
                if(!inRange(nr, nc) || visited[nr][nc] || grid[nr][nc] == 0) continue;

                // 탐색 가능한 경우 큐에 추가
                visited[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }
    }
}

