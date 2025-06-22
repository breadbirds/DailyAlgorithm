import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_분수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		// (r, c)
		//     1   2   3   4   5   6
		// 1:  1,  2,  6,  7,  15, 16
		// 2:  3,  5,  8,  14, 17
		// 3:  4,  9,  13, 18  
		// 4:  10, 12, 19
		// 5:  11, 20
		// 6:  21
		// r   | c      | r         | c
		// (1) | (2, 3) | (4, 5, 6) | (7, 8, 9, 10)
		// 1, 3, 6, 10, ...
		int current = 1;
		int cnt = 1;
		int r = 1, c = 1;
		
		while (current < n) {
			cnt++;
			current += cnt;
		}
		
		int gap = current - n;
		
		if (cnt % 2 == 0) {
			r = cnt - gap;
			c = gap + 1;
		} else {
			r = gap + 1;
			c = cnt - gap;
		}
		
		System.out.println(r + "/" + c);
	}

}
