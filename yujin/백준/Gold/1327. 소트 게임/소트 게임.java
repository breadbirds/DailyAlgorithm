import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String num = st.nextToken();
            sb.append(num);
            sorted.add(Integer.parseInt(num));
        }

        String start = sb.toString();

        Collections.sort(sorted);
        StringBuilder goalSb = new StringBuilder();
        for (int x : sorted) goalSb.append(x);
        String goal = goalSb.toString();

        System.out.println(bfs(start, goal));
    }

    static int bfs(String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        queue.offer(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int depth = dist.get(cur);

            if (cur.equals(goal)) return depth;

            for (int i = 0; i <= N - K; i++) {
                String next = reverse(cur, i, i + K - 1);
                if (!dist.containsKey(next)) {
                    dist.put(next, depth + 1);
                    queue.offer(next);
                }
            }
        }

        return -1;  // 정렬 불가능한 경우
    }

    static String reverse(String s, int l, int r) {
        char[] arr = s.toCharArray();
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
    }
}