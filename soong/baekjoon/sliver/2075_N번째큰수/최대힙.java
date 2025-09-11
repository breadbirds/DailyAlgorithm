import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				pq.add(map[i][j]);
			}
		}

		for (int i = 0; i < N - 1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}

}
