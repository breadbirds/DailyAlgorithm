import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int N, K;
	static int swapCnt = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);

		int[] nums = new int[N];
		
		split = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(split[i]);
		}

		selectionSort(nums, N - 1);

		System.out.println(-1);

	}

	static void selectionSort(int[] nums, int last) {

		if (last <= 0) {
			return;
		}

		int max = nums[0];
		int maxIdx = 0;
		for (int i = 0; i <= last; i++) {
			if (max < nums[i]) {
				max = nums[i];
				maxIdx = i;
			}
		}

		if (maxIdx != last) {
			int tmp = nums[maxIdx];
			nums[maxIdx] = nums[last];
			nums[last] = tmp;
			swapCnt++;
			if (swapCnt == K) {
				System.out.println(nums[maxIdx] + " " + nums[last]);
				System.exit(0);
			}
		}

		selectionSort(nums, last - 1);

	}

}
