import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_알파벳찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] alphabets = new int[26];

		for (int i = 0; i < 26; i++) {
			alphabets[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			int seq = str.charAt(i) - 97;
			
			if (alphabets[seq] == -1) {
				alphabets[seq] = i;
			}
		}
		

		for (int i = 0; i < 26; i++) {
			System.out.print(alphabets[i] + " ");
		}
	}

}
