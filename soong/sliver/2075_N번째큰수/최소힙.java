import java.io.*;
import java.util.*;

public class 최소힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(split[j]);
                pq.add(num);

                // 힙 크기를 N으로 제한
                if (pq.size() > N) {
                    pq.poll(); // 가장 작은 수 제거
                }
            }
        }

        System.out.println(pq.peek()); // N번째 큰 수
    }
}
