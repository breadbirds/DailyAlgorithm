package source_code;

import java.io.*;
import java.util.*;

// 누른 순서대로 대기목록 들어감
// 대기에서 다시 누르면 맨 뒤로 밀림
// 버튼 비활 후 앞에서부터 수강신청 처리 -> 꽉 차면 종료됨

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

		// 2. 제시된 인원 수 수강 인원에 추가
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
