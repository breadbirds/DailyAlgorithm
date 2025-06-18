import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int temp = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			
			// init 
			temp = i;
			sum = 0;
			
			// 각 자리수의 합을 구하는 과정
			while(temp > 0) {
				sum += temp%10;
				temp /= 10;
			}
			
			// 분해합인지 판별
			if(sum + i == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);

	}
}