import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		System.out.println(a * b);
	}

}
