import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String split = br.readLine();
		char[] ops = new char[N / 2];
		int[] nums = new int[N / 2 + 1];

		int idx1 = 0, idx2 = 0;
		for (char sp : split.toCharArray()) {
			if (sp >= '0' && sp <= '9') nums[idx1++] = sp - '0';
			else ops[idx2++] = sp;
		}
		
		dfs(0, nums[0], ops, nums);
		System.out.println(answer);
		
	}
	
	static int answer = Integer.MIN_VALUE;
	static void dfs(int idx, int currentValue, char[] ops, int[] nums) {
		
		if (idx == ops.length) {
			answer = Math.max(answer, currentValue);
			return;
		}
		
		// 괄호X
		dfs(idx + 1, calc(currentValue, ops[idx], nums[idx + 1]), ops, nums);
		
		// 괄호O
		if (idx + 1 < ops.length) {
			int num = calc(nums[idx + 1], ops[idx + 1], nums[idx + 2]);
			dfs(idx + 2, calc(currentValue, ops[idx], num), ops, nums);
		}
	}
	
	static int calc(int a, char op, int b) {
		if (op == '+') return a + b;
		if (op == '-') return a - b;
		if (op == '*') return a * b;
		if (op == '/') return a / b;
		return -1;
	}

}
