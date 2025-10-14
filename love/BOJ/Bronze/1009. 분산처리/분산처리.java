import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1009
 * 
 * 
 * 풀이 방법
 * - 어떤 제곱값이 나오더라도, 첫째자리 숫자만 보면 된다. => ' a % 10' 활용
 * 
 * 오답 기록
 * - 문제만 읽고, Math.pow() 를 통해 제곱값을 계산하였으나, 너무 큰 값이 발생할 경우 오버플로우 발생
 * - 꼭 모든 값의 제곱을 구해야하는 것이 아니다. 풀이 방법에 적었던 것 처럼 1의 자리 숫자만 보면 되기 때문!
 */

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test_case = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<test_case; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 틀린 방식
			// double datas = Math.pow(a, b);
			
			// 개선된 방식 : 1의 자리 값만 변경하며 기록하는 것이 핵심
			int answer = 1;
			for(int j=0; j<b;j++) {
				answer = (answer*a) % 10;
			}
			
			if(answer == 0) {
				answer = 10;
			}
			
			System.out.println(answer);
		}
		

	}
}


