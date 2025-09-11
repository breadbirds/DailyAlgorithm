package source_code;

import java.io.*;
import java.util.*;

public class B_S5_1543_SearchDocuments {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String str = br.readLine();
		int result = 0;
		int idx = 0;

		while (idx < input.length() - str.length() + 1) {
			if (input.substring(idx, idx + str.length()).equals(str)) {
				result++;
				idx += str.length();
			} else {
				idx++;
			}
		}

		System.out.println(result);
	}

}
