import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A: N x M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // B: M x K
        st = new StringTokenizer(br.readLine());
        int M2 = Integer.parseInt(st.nextToken()); // should be M
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M2][K];

        for (int i = 0; i < M2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // C = A x B : N x K
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                long sum = 0;
                for (int t = 0; t < M; t++) {
                    sum += (long) A[i][t] * B[t][j];
                }
                sb.append(sum);
                if (j + 1 < K) sb.append(' ');
            }
            if (i + 1 < N) sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
