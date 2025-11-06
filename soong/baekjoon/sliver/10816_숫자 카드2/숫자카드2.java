import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class 숫자카드2 {

	static int n, m;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(split[i]);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		m = Integer.parseInt(br.readLine());
		split = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(split[i]);
			System.out.print(map.getOrDefault(key, 0) + " ");
		}

	}
}
