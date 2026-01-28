import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, S, Y;// 학생수, 방배정 최대 인원수, 성별(0여자1남자), 학년
	static int wRoom[] = new int[7];
	static int mRoom[] = new int[7];

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			if(S == 0) {
				wRoom[Y]++;
			}
			if(S == 1) {
				mRoom[Y]++;
			}
	
		}
		int sum = 0;
		for (int i = 1; i < 7; i++) {
			if(mRoom[i] % K == 0) {
				sum+= mRoom[i] / K;
			}
			else {
				sum+= mRoom[i] / K +1;
			}
			if(wRoom[i] % K == 0) {
				sum+= wRoom[i] / K;
			}
			else {
				sum+=wRoom[i] / K +1;
			}
		}
		
		System.out.println(sum);
	}
}