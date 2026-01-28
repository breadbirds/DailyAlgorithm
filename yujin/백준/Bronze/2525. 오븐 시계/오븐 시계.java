import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 현재시각 A시 B분
		// 요리하는데 걸리는 시간 C분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A, B, C;

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());

		int hour;
		int minute;
		
		
		if ((B + C) >= 60) {
			minute = (B + C) % 60;
			hour = (A + (B + C) / 60) % 24;

		} else {
			minute = B + C;
			hour = A % 24;
		}
//		if(A > 23) {
//			hour = A % 24;
//		}

		System.out.println(hour + " " + minute);

	}
}