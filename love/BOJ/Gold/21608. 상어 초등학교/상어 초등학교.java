import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int total = N * N;

        // 좋아하는 학생 정보를 빠르게 조회하기 위해 boolean 테이블 사용
        // like[a][b] = a 학생이 b 학생을 좋아하면 true
        boolean[][] like = new boolean[total + 1][total + 1];

        // 입력 순서(배치 순서)로 학생 번호를 보관
        int[] order = new int[total];

        // 각 줄: s fav1 fav2 fav3 fav4
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            order[i] = s;
            for (int k = 0; k < 4; k++) {
                int f = Integer.parseInt(st.nextToken());
                like[s][f] = true;
            }
        }

        int[][] board = new int[N][N]; // 0 = 빈칸

        // 1) 학생을 입력 순으로 한 명씩 배치
        for (int idx = 0; idx < total; idx++) {
            int s = order[idx];

            int bestX = -1, bestY = -1;
            int bestLike = -1;   // 인접 좋아하는 학생 수
            int bestEmpty = -1;  // 인접 빈칸 수

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (board[x][y] != 0) continue; // 이미 누가 앉음

                    int likeCnt = 0;
                    int emptyCnt = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                        if (board[nx][ny] == 0) emptyCnt++;
                        else if (like[s][board[nx][ny]]) likeCnt++;
                    }

                    // 규칙 우선순위 비교
                    if (likeCnt > bestLike
                            || (likeCnt == bestLike && emptyCnt > bestEmpty)
                            || (likeCnt == bestLike && emptyCnt == bestEmpty && (x < bestX
                                || (x == bestX && y < bestY)))) {
                        bestLike = likeCnt;
                        bestEmpty = emptyCnt;
                        bestX = x;
                        bestY = y;
                    }
                }
            }

            board[bestX][bestY] = s;
        }

        // 2) 만족도 계산
        int[] score = {0, 1, 10, 100, 1000};
        int ans = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int s = board[x][y];
                int likeCnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (like[s][board[nx][ny]]) likeCnt++;
                }
                ans += score[likeCnt];
            }
        }

        System.out.println(ans);
    }
}
