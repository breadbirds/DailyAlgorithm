import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int left = 0;
        int right = R - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isUnique(mid)) {
                answer = mid; // 더 위까지 자를 수 있으므로 증가
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 위에서 row 행까지 잘랐을 때, 열 단위 문자열이 모두 유일한지 확인
    static boolean isUnique(int row) {
        Set<String> set = new HashSet<>();

        for (int col = 0; col < C; col++) {
            StringBuilder sb = new StringBuilder();
            for (int r = row; r < R; r++) {
                sb.append(map[r][col]);
            }
            if (!set.add(sb.toString())) {
                return false; // 중복 있음
            }
        }

        return true; // 모두 유일
    }
}
