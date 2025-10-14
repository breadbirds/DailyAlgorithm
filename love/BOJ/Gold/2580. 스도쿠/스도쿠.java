import java.io.*;
import java.util.*;

/**
 * BOJ 2580 스도쿠
 * - 백트래킹(DFS)으로 풀이
 * - 빈칸 좌표만 리스트로 모아 인덱스로 재귀 진행
 * - 행/열/박스에 어떤 숫자가 이미 쓰였는지 캐시(rows, cols, boxes)로 O(1) 체크
 */
public class Main {
	
	static class Node {
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

    static final int N = 9;
    static int[][] grid = new int[N][N];
    static List<Node> blanks = new ArrayList<>();

    // 사용 여부 캐시
    static boolean[][] rows = new boolean[N][N+1];  // rows[r][v] : r행에 숫자 v가 이미 존재하면 true
    static boolean[][] cols = new boolean[N][N+1];  // cols[c][v] : c열에 숫자 v가 이미 존재하면 true
    static boolean[][] boxes = new boolean[N][N+1]; // boxes[b][v]: b번 3x3 박스에 숫자 v가 이미 존재하면 true

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init + input
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int v = Integer.parseInt(st.nextToken());
                grid[r][c] = v;
                
                // 값이 0인 경우, 내가 값을 채워넣어야 하기 때문에 리스트에 해당 위치를 추가해준다.
                if (v == 0) {
                    blanks.add(new Node(r, c));
                } else {
                    rows[r][v] = true;
                    cols[c][v] = true;
                    boxes[boxIndex(r, c)][v] = true;
                }
            }
        }

        // Simulation
        dfs(0);

        // Result
        print_box();

    }// ...main

    private static void print_box() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(grid[r][c]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
	}

	/**
     * idx번째 빈칸을 채우는 재귀 함수
     * - 해답을 찾으면 true를 반환하여 재귀를 상향 종료
     */
    static boolean dfs(int idx) {
        if (idx == blanks.size()) return true; // 모든 빈칸 완료
        
        // 1. 채워 넣어야하는 값을 하나씩 꺼낸다.
        Node cur = blanks.get(idx);
        int r = cur.x;
        int c = cur.y;
        int b = boxIndex(r, c);

        // 2. 그 위치에 1~9까지 가능한 숫자를 찾아 넣어본다.
        for (int v = 1; v <= 9; v++) {
        	
            // 2-1. 탐색 불가 : 행/열/박스에 v 가 있는 경우
            if (rows[r][v] || cols[c][v] || boxes[b][v]) continue;

            // 2-2. 가능한 숫자 사용(상태 갱신)
            grid[r][c] = v;
            rows[r][v] = true;
            cols[c][v] = true;
            boxes[b][v] = true;

            // 2-3. 다음 빈칸 이동 (단, 직접적으로 list에서 제거하는게 아니라 넘기는 방식으로)
            if (dfs(idx + 1)) 
            	return true;

            // 2-4. 다를 후보(숫자)를 탐색하기 위해 되돌리기(백트래킹)
            grid[r][c] = 0;
            rows[r][v] = false;
            cols[c][v] = false;
            boxes[b][v] = false;
        }
        
        // 어떤 값도 성공하지 못할 경우 :  이 칸에서 해답 없음 → 상위로 실패 전달
        return false;
    }

    /**
     * (r,c)가 속한 3x3 박스 인덱스(0~8) 반환
     * (r/3) * 3 : 세로 블록 박스 번호
     * + (c/3) : 가로 블록 위치
     * 
     * 박스 배치:
     * 0번째줄 : 0 1 2
     * 1번째줄 : 3 4 5
     * 2번째줄 : 6 7 8
     */
    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
