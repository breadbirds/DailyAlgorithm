import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine().toUpperCase();
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		List<Character> keySet = new ArrayList<>(map.keySet());
		
		keySet.sort(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
			
		});
		
		char result = ' ';
		
		if (keySet.size() > 1 && map.get(keySet.get(0)).equals(map.get(keySet.get(1)))) {
			result = '?';
		} else {
			result = keySet.get(0);
		}
		
		System.out.println(result);
	}

}
