package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_S2_2512_budget {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cityCnt = Integer.parseInt(br.readLine());
		String[] budgets = br.readLine().split(" ");
		int[] cityBudget = new int[cityCnt];

		for (int i = 0; i < cityCnt; i++) {
			cityBudget[i] = Integer.parseInt(budgets[i]);
		}

		int totalBudget = Integer.parseInt(br.readLine());

		// 각 예산 합이 총액보다 작으면 그냥 바로 출력
		int sumBudget = 0;
		int maxBudget = 0;

		for (int i : cityBudget) {
			sumBudget += i;
		}

		if (sumBudget <= totalBudget) {
			maxBudget = getMaxBudget(cityCnt, cityBudget);
		} else { // 그게 아니라면 상한선 찾아서 출력하기
			maxBudget = findMaxLine(cityCnt, cityBudget, totalBudget);
		}

		System.out.println(maxBudget);

	}

	private static int findMaxLine(int cityCnt, int[] cityBudget, int totalBudget) {
		// **
		int left = 0;
		int right = 0;

		for (int i = 0; i < cityCnt; i++) {
			right = Math.max(right, cityBudget[i]);
		}

		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 0; i < cityCnt; i++) {
				sum += Math.min(cityBudget[i], mid);
			}

			if (sum <= totalBudget) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}

	private static int getMaxBudget(int cityCnt, int[] cityBudget) {
		int maxBudget = 0;

		for (int i = 0; i < cityCnt; i++) {
			if(cityBudget[i] > maxBudget) {
				maxBudget = cityBudget[i];
			}
		}

		return maxBudget;
	}

}
