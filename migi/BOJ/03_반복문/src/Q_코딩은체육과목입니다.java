import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_코딩은체육과목입니다 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()) / 4;
		
		String result = "";
		
		for (int i = 0; i < n; i++) {
			result += "long ";
		}
		result += "int";
		
		System.out.println(result);
	}

}
