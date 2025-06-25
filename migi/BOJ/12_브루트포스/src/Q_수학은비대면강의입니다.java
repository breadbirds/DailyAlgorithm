import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_수학은비대면강의입니다 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		// x = (c - by) / a
		// x = (f - ey) / d
		// d(c - by) = a(f - ey)
		// cd - bdy = af - aey
		// -(bd - ae)y = af - cd
		// y = (cd - af) / (bd - ae)
		
		int y = 0;
		int x = 0;
		
		if (b * d - a * e != 0) {
			y = (c * d - a * f) / (b * d - a * e);
		}
		
		if (a != 0) {
			x = (c - b * y) / a;
		}
		
		if (d != 0) {
			x = (f - e * y) / d;
		}
		
		System.out.println(x + " " + y);
	}
	
}
