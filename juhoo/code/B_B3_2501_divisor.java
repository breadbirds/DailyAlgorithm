package source_code;

import java.io.*;
import java.util.*;

public class B_B3_2501_divisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int num = 1;
		boolean exist = false;

		while (num <= N) {
			if (N % num == 0) {
				cnt++;

				if (cnt == K) {
					exist = true;
					break;
				}
			}

			num++;
		}

		if(exist == false) {
			num = 0;
		}
		
		System.out.println(num);

	}
}
