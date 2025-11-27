package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1406_Editor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		List<Character> memo = new LinkedList<>(); // 현재 상황을 저장할 리스트

		for (int i = 0; i < input.length(); i++) {
			memo.add(input.charAt(i));
		}

		ListIterator<Character> it = memo.listIterator();

		int inputCnt = Integer.parseInt(br.readLine());

		// 커서 제일 뒤로 옮기기
		while (it.hasNext()) {
			it.next();
		}

		// 입력 시작
		for (int i = 0; i < inputCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char key = st.nextToken().toCharArray()[0];

			if (key == 'L') {
				if (it.hasPrevious()) {
					it.previous();
				}
			} else if (key == 'D') {
				if (it.hasNext()) {
					it.next();
				}
			} else if (key == 'B') {
				if (it.hasPrevious()) {
					it.previous();
					it.remove();
				}

			} else {
				char c = st.nextToken().toCharArray()[0];

				it.add(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : memo) {
			sb.append(c);
		}

		System.out.println(sb);
	}

}
