package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1927_minHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (queue.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(num);
			}
		}

	}
}
