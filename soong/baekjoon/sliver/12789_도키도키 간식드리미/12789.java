import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] nums = new int[n];

		Stack<Integer> students = new Stack<>();
		int ans = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(split[i]);
			if (ans == nums[i]) {
				ans++;
			} else {
				students.add(nums[i]);
			}
			if (!students.isEmpty() && students.peek() == ans) {
				while (!students.isEmpty() && students.peek() == ans) {
					students.pop();
					ans++;
				}

			}
		}

		while (!students.isEmpty()) {
			int num = students.pop();
			if (num == ans) {
				ans++;
			} else {
				break;
			}
		}

		if (students.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");

	}
}
