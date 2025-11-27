package source_code;

import java.io.*;
import java.util.*;

public class B_B1_1032_CmdPrompt {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		for (int i = 0; i < str[0].length(); i++) {
			boolean isSame = true;

			for (int j = 0; j < str.length - 1; j++) {
				if (str[j].charAt(i) != str[j + 1].charAt(i)) {
					isSame = false;
					break;
				}
			}

			if (isSame == true && str[0].charAt(i) == '.') {
				result.append(".");
			} else if (isSame == true && str[0].charAt(i) != '.') {
				result.append(str[0].charAt(i));
			} else {
				result.append("?");
			}
		}

		System.out.println(result);
	}

}
