import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_주사위세개 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()) - 45;
		
		if (m < 0) {
			h -= 1;
			m += 60;
			
			if (h < 0) {
				h += 24;
			}
		} 
		
		System.out.println(h + " " + m);
	}

}
