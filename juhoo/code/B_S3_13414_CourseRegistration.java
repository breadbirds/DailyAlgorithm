package source_code;

import java.io.*;
import java.util.*;

// ���� ������� ����� ��
// ��⿡�� �ٽ� ������ �� �ڷ� �и�
// ��ư ��Ȱ �� �տ������� ������û ó�� -> �� ���� �����

public class B_S3_13414_CourseRegistration {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Map<String, Integer> cnt = new LinkedHashMap<>();

		for (int i = 0; i < L; i++) {
			String number = br.readLine();
			if (cnt.containsKey(number)) {
				cnt.remove(number);
				cnt.put(number, 1);
			} else {
				cnt.put(number, 1);
			}
		}

		// 2. ���õ� �ο� �� ���� �ο��� �߰�
		StringBuilder sb = new StringBuilder();
		List<Map.Entry<String, Integer>> numbers = new ArrayList<>(cnt.entrySet());
		int currentCnt = 0;
		
		for (int i = 0; i < numbers.size(); i++) {
			if(currentCnt == K) {
				break;
			}
			
			sb.append(numbers.get(i).getKey());

			if (i != K - 1) {
				sb.append("\n");
			}
			
			currentCnt++;
		}
		System.out.println(sb);
	}

}
