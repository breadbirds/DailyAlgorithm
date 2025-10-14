import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * 
 * - 정수를 하나 외치면, 지금까지 말한 수 중에서 중간값을 말해야 함.
 * - 수의 개수가 짝수개라면, 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 최대 힙 (왼쪽: 중간값 이하)
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		// 최소 힙 (오른쪽: 중간값 초과)
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			// 1. maxHeap에 먼저 넣기 (필수)
			maxHeap.offer(num);

			// 2. minHeap보다 큰 값이 maxHeap에 있을 경우 이동
			if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(minHeap.poll());
			}

			// 3. size 조절: maxHeap이 항상 크거나 같아야 함
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
}