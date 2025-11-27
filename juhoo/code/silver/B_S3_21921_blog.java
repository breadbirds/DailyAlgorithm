package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_S3_21921_blog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int dayCnt = Integer.parseInt(input[0]);
		int duration = Integer.parseInt(input[1]);

		int[] visitCnt = new int[dayCnt];
		input = br.readLine().split(" ");

		for (int i = 0; i < dayCnt; i++) {
			visitCnt[i] = Integer.parseInt(input[i]);
		}

		// 초기 기간 sum 세팅
		List<Integer> visitInDuration = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < duration; i++) {
			sum += visitCnt[i];
		}

		visitInDuration.add(sum);

		// 뒷 기간도 마저 계산 후 리스트에 저장
		for (int i = 1; i <= (dayCnt - duration); i++) {
			sum -= visitCnt[i - 1];
			sum += visitCnt[i + duration - 1];

			visitInDuration.add(sum);
		}

		int max = Collections.max(visitInDuration);

		// max 값이 리스트에 몇 개인지 확인
		int sameNumCnt = 0;

		for (int i : visitInDuration) {
			if (i == max)
				sameNumCnt++;
		}

		StringBuilder sb = new StringBuilder();

		if (max == 0) {
			sb.append("SAD");
		} else {
			sb.append(max).append('\n');
			sb.append(sameNumCnt);
		}

		System.out.println(sb);
	}

}
