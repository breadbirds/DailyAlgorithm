import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 1️⃣ 정렬
        Arrays.sort(P);

        // 2️⃣ 누적 합 계산
        int sum = 0;       // 지금까지 누적된 합
        int total = 0;     // 전체 합

        for (int i = 0; i < N; i++) {
            sum += P[i];   // i번째 사람까지의 누적합
            total += sum;  // 전체 합에 더하기
        }

        System.out.println(total);
    }
}
