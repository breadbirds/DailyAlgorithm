import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - N*N 도시
 * - 각 칸은 빈 칸(0), 집(1), 치킨 집(2) 중 하나
 * - 치킨 거리 : 집과 '가장 가까운' 치킨집 사이의 거리 (각 집은 치킨 거리를 가지고 있으며, 집을 기준으로 정해짐)
 *             도시의 치킨 거리는 모든 집의치킨 거리의 합
 * - 일부 치킨집을 폐업시키려고 한다. 도시에서 가장 수익을 많이 낼 수 있는 치킨집의 최대 개수 M 개를 고르고
 *   나머지 치킨집은 모두 폐업 시킬 때, 도시의 치킨 거리가 가장 작게 구해지는 프로그램을 작성하여라
 *   (치킨 거리는 짧을 수록 좋은 것)
 *   
 * - 치킨거리 : |r1-r2| + |c1-c2|
 * 
 * 
 * 부가 조건
 * - 집의 개수는 2N 개를 넘기지 않는다.
 * - 집은 적어도 1개 이상 존재한다.
 * - 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
 *             
 */

public class Main {

    static class Node {
        int r, c;
        
        Node(int r, int c){ 
        	this.r = r; 
        	this.c = c; 
        }
    }

    static int N, M;
    static List<Node> homes = new ArrayList<>();
    static List<Node> shops = new ArrayList<>();
    static int H, C;
    static int[][] dist;          // dist[h][c] = 집 h 와 치킨집 c 사이 맨해튼거리
    static int[] pick;            // 고른 치킨집 인덱스 M개
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                
                // 집, 치킨집 구분
                if (v == 1) homes.add(new Node(i, j));
                else if (v == 2) shops.add(new Node(i, j));
            }
        }

        H = homes.size();
        C = shops.size();
        dist = new int[H][C];

        // 미리 거리 계산(매 조합 평가 O(H*M)로 축소)
        // dist[][] 각 위치에집 h와 치킨집 c의 거리가 계산된다.
        for (int h = 0; h < H; h++) {
            for (int c = 0; c < C; c++) {
            	// 집 하나와 나머지 모든 치킨 집 뽑기
            	Node a = homes.get(h);
            	Node b = shops.get(c);
                dist[h][c] = Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
            }
        }

        pick = new int[M];
        comb(0, 0);

        System.out.println(answer);
    }

	 // depth: 지금까지 고른 개수
	 // start: 이번에 고를 치킨집 시작 인덱스
    static void comb(int depth, int start) {
    	
    	// 목표 치킨집 운영수(M)에 도달하면 멈춤
        if (depth == M) {
            
            int sum = 0;
            for (int h = 0; h < H; h++) {
                int best = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    best = Math.min(best, dist[h][pick[k]]);
                    
                    // 더 작아질 수 없음(미세 가지치기)
                    if (best == 0) break; 
                }
                sum += best;
                
             // 가지치기(현재 최적 초과)
                if (sum >= answer) return; 
            }
            answer = Math.min(answer, sum);
            return;
        }
        
        // 치킨집을 더 제거해야하는 경우 : depth 에서 어떤 치킨집을 고를지 모든 후보 시도
        for (int i = start; i < C; i++) {
            pick[depth] = i;
            comb(depth + 1, i + 1);
        }
    }
}

