import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * 문제 정리하기
 * - N 개의 숫자, N-1 개의 연산자(+, -, *, / 총 4가지만 존재)
 * - 정수의 위치는 변경할 수 없으며, 각 수 사이에 연산자를 하나씩 넣어 수식을 만든다.
 * - "연산자의 우선순위는 무시" 하고, 수의 앞에서 부터 계산을 한다. ++ 나눗셈은 정수 나눗셈으로 몫만 취한다. ++
 * - 중복/동일한 연산은 안됨 !
 * - 출력 조건 : 최댓값, 최솟값을 출력해라.
 */

public class Main {
	
	static int maxValue, minValue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		maxValue = Integer.MIN_VALUE;
		minValue = Integer.MAX_VALUE;

		// 주어진 수 An
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자의 순서는 고정 : +, -, *, /
		st = new StringTokenizer(br.readLine());
		int[] op = new int[4];  // 0: +, 1: -, 2: *, 3: /
		for (int i = 0; i < 4; i++) {
		    op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, num[0], num, op); // 첫 번째 숫자는 result에 넣고 시작

		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void dfs(int idx, int result, int[] num, int[] op) {
	    if (idx == num.length) {
	        maxValue = Math.max(maxValue, result);
	        minValue = Math.min(minValue, result);
	        return;
	    }

	    for (int i = 0; i < 4; i++) {
	    	// 사용할수 있는 연산자의 횟수도 정해져있기 때문에 op[i] 로 판단한다.
	        if (op[i] > 0) {
	            op[i]--;

	            int next = 0;
	            if (i == 0) next = result + num[idx];
	            else if (i == 1) next = result - num[idx];
	            else if (i == 2) next = result * num[idx];
	            else next = result / num[idx]; // 정수 나눗셈

	            dfs(idx + 1, next, num, op);
	            op[i]++; // 원복
	        }
	    }
	}
	
}