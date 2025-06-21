import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			Map<Character, Integer> map = new HashMap<>();
			boolean flag = true;
			
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				int lastIdx = map.getOrDefault(ch, j);
				
				if (lastIdx == j) {
					map.put(ch, lastIdx);
				} else if (lastIdx == j - 1) {
					map.put(ch, lastIdx + 1);
				} else {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
