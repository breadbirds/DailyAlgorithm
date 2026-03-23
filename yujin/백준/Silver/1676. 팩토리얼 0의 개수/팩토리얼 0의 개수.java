import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num = 1;
		// N! 구하기
//		for (int i = 1; i <= N; i++) {
//			num = i * num;
//		}
		// 뒤에서 처음 0이 아닌 수가 나올 때 0의 개수
		int cnt = 0;
		for(int i = 5; i <= N; i*=5) {
			cnt += N/ i ;
		}
		System.out.println(cnt);
	}

}