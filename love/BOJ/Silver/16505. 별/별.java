import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] board;
    static int n;         // 입력받은 N (지수)
    static int size;      // 실제 한 변 길이 = 2^N

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        size = 1 << n;              // 2^n

        board = new char[size][size];

        // 처음엔 전부 공백으로 채우기
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }

        // (0,0)을 시작점으로 전체 크기 size에 대해 재귀 호출
        draw(size, 0, 0);

        StringBuilder sb = new StringBuilder();

        // i번째 줄에서는 0 ~ (size - i - 1)까지만 출력 (뒤 공백 제거용)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                sb.append(board[i][j]);
            }
            if (i != size - 1) {
                sb.append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    // size x size 정사각형을 (r, c)에서 시작해서 별 패턴으로 채우는 함수
    private static void draw(int size, int r, int c) {
        // 더 쪼갤 수 없는 1x1 크기가 되면 별 하나 찍고 끝
        if (size == 1) {
            board[r][c] = '*';
            return;
        }

        int half = size / 2;

        // 왼쪽 위
        draw(half, r, c);
        // 오른쪽 위
        draw(half, r, c + half);
        // 왼쪽 아래
        draw(half, r + half, c);
    }
}
