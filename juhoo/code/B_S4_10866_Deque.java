package source_code;

import java.io.*;
import java.util.*;

public class B_S4_Deque {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> dq = new LinkedList<>(); // 중간 인덱스 편집이 있어서 LinkedList 구현체 사용함

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = Integer.MIN_VALUE;

			if (command.equals("push_front")) {
				int n = Integer.parseInt(st.nextToken());
				dq.addFirst(n);
			} else if (command.equals("push_back")) {
				int n = Integer.parseInt(st.nextToken());
				dq.addLast(n);
			} else if (command.equals("pop_front")) {
				if (dq.isEmpty()) {
					num = -1;
				} else {
					num = dq.removeFirst();
				}
			} else if (command.equals("pop_back")) {
				if (dq.isEmpty()) {
					num = -1;
				} else {
					num = dq.removeLast();
				}
			} else if (command.equals("size")) {
				num = dq.size();
			} else if (command.equals("empty")) {
				num = (dq.isEmpty()) ? 1 : 0;
			} else if (command.equals("front")) {
				if (dq.isEmpty()) {
					num = -1;
				} else {
					num = dq.peekFirst();
				}
			} else {
				if (dq.isEmpty()) {
					num = -1;
				} else {
					num = dq.peekLast();
				}
			}

			if (num != Integer.MIN_VALUE) {
				System.out.println(num);
			}
		}
	}

}
