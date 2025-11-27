package source_code;

import java.io.*;
import java.util.*;

public class B_S5_14405_Pikachu {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] canSpeackArray = { "pi", "ka", "chu" };
		String result = "YES";

		for (int i = 0; i < canSpeackArray.length; i++) {
			S = S.replaceAll(canSpeackArray[i], " ");
		}

		for (int c : S.toCharArray()) {
			if (c != ' ') {
				result = "NO";
				break;
			}
		}

		System.out.println(result);
	}

}
