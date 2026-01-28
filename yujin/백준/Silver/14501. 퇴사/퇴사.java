import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T, P, money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        money = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 상담 진행 여부 결정하는 반복문
        for (int i = 1; i <= N; i++) {
            // 오늘 상담을 하지 않고 다음 날로 넘길 경우
            money[i] = Math.max(money[i], money[i - 1]);

            // 오늘 상담을 할 경우, 그 상담이 끝나는 날짜에 수익을 더함
            if (i + T[i] - 1 <= N) {
                money[i + T[i] - 1] = Math.max(money[i + T[i] - 1], money[i - 1] + P[i]);
            }
        }

        // 마지막 날까지 최대 수익을 계산하여 출력
        System.out.println(Math.max(money[N], money[N - 1]));
    }
}