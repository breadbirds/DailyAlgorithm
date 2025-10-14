import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        // 최다 판매 수 찾기
        int max = 0;
        for (int cnt : map.values()) {
            if (cnt > max) max = cnt;
        }

        // 사전순 정렬을 위해 TreeSet 또는 리스트 사용
        List<String> candidates = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                candidates.add(key);
            }
        }

        Collections.sort(candidates);  // 사전순 정렬
        System.out.println(candidates.get(0));  // 가장 앞선 책 제목 출력
    }
}
