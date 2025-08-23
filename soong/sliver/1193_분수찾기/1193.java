
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		int line = 1;
		int sum = 1; // 누적합
		while (X > sum) {
			line++;
			sum += line;
		}

		int posInLine = X - (sum - line);
		int a, b;
		if (line % 2 == 0) { // 짝수일 때
			a = posInLine;
			b = line - posInLine + 1;

		} else { // 홀수 일 때
			a = line - posInLine + 1;
			b = posInLine;
		}

		System.out.println(a + "/" + b);
	}
}