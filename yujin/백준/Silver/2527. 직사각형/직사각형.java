import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x1, y1, x2, y2, x3, y3, x4, y4;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());
			
			// d
			if(x2 < x3 || y2 < y3 || x1 > x4 || y1 > y4) {
				System.out.println("d");
			}
			// c
			else if((x2 == x3 && y1 == y4) ||(x1 == x4 && y2 == y3)||(x1 == x4 && y1 == y4)||(x2 == x3 && y2 == y3)) {
				System.out.println("c");
			}
			// b
			else if(x2 == x3 || y2 == y3 || x4 == x1 || y1 == y4) {
				System.out.println("b");
			}
			// a
			else {
				System.out.println("a");
			}
			
		}
		
	}
}