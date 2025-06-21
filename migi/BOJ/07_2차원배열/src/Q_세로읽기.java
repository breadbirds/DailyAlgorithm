import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[][] arr = new String[15][15];
		String result = "";
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				arr[j][i] = "" + str.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] != null) {
					result += arr[i][j];
				}
			}
		}
		
		System.out.println(result);
	}

}
