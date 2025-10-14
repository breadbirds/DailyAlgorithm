import java.util.*;

public class Main {
    static int N, C;
    static int[] houses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses);

        int left = 1; // 최소 거리 (0은 의미 없음)
        int right = houses[N - 1] - houses[0]; // 최대 거리 차
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isInstallable(mid)) {
                answer = mid;         // 가능하니까 거리 늘려보자
                left = mid + 1;
            } else {
                right = mid - 1;      // 너무 좁게 설치됨 → 거리 줄여야 함
            }
        }

        System.out.println(answer);
    }

    static boolean isInstallable(int distance) {
        int count = 1; // 첫 집엔 설치
        int lastInstalled = houses[0];

        for (int i = 1; i < N; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
            }
        }

        return count >= C;
    }
}
