import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1998년생인내가태국에서는2541년생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		System.out.println(year - 2541 + 1998);
	}

}
