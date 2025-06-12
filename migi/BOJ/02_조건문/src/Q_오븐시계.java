import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_오븐시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(br.readLine());
		
		int total = h * 60 + m + min;
		int resultH = total / 60;
		if (resultH >= 24) {
			resultH %= 24;
		}
		
		int resultM = total % 60;
		
		System.out.println(resultH + " " + resultM);
	}

}
