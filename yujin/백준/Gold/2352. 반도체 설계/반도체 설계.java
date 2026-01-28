import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int now = arr[i];
            int idx = Collections.binarySearch(lis, now);

            if (idx < 0) idx = -(idx + 1);  // lower_bound 위치

            if (idx == lis.size()) {
                lis.add(now);
            } else {
                lis.set(idx, now);  // 더 작은 값으로 갱신
            }
        }

        System.out.println(lis.size());
    }
}