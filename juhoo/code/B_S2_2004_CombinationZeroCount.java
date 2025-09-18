package source_code;

import java.io.*;
import java.util.*;

public class B_S2_2004_CombinationZeroCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		int nCnt1 = getZeroCnt(n, 5);
		int mCnt1 = getZeroCnt(m, 5);
		int nmCnt1 = getZeroCnt(n - m, 5);

		int nCnt2 = getZeroCnt(n, 2);
		int mCnt2 = getZeroCnt(m, 2);
		int nmCnt2 = getZeroCnt(n - m, 2);

		System.out.println(Math.min(nCnt1 - mCnt1 - nmCnt1, nCnt2 - mCnt2 - nmCnt2));

	}

	private static int getZeroCnt(long n, int multiple) {
		int zeroCnt = 0;
		long multi = multiple;

		while (true) {
			if (n / multi == 0) {
				break;
			}

			zeroCnt += n / multi;
			multi *= multiple;
		}

		return zeroCnt;
	}

}
