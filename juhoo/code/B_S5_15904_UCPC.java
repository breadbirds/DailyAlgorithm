package source_code;

import java.io.*;
import java.util.*;

public class B_S5_15904_UCPC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] word = { 'U', 'C', 'P', 'C' };
		int idxWord = 0;

		for (char s : str) {
			if (word[idxWord] == s) {
				idxWord++;
			}

			if (idxWord == word.length) {
				break;
			}
		}

		if (idxWord == word.length) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}

	}

}
