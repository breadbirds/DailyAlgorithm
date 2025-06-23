import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q_네번째점 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Set<Integer> setX = new HashSet<>();
		Set<Integer> setY = new HashSet<>();
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (setX.contains(x)) {
				setX.remove(x);
			} else {
				setX.add(x);
			}
			
			if (setY.contains(y)) {
				setY.remove(y);
			} else {
				setY.add(y);
			}
		}
		
		System.out.println(setX.toArray()[0] + " " + setY.toArray()[0]);
	}

}
