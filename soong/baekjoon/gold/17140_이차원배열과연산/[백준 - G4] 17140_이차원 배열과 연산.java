import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int r, c, k;
	static List<List<Integer>> map;
	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		r = Integer.parseInt(split[0]) - 1;
		c = Integer.parseInt(split[1]) - 1;
		k = Integer.parseInt(split[2]);

		map = new ArrayList<List<Integer>>();
		list = new ArrayList<List<Integer>>();
		for (int i = 0; i < 3; i++) {
			split = br.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < 3; j++) {
				arr.add(Integer.parseInt(split[j]));
			}
			map.add(arr);
		}

		int time = 0;

		while (time <= 100) {
			if (r < map.size() && c < map.get(0).size() && 
					map.get(r).get(c) == k) {
				System.out.println(time);
				return;
			}

			if (map.size() >= map.get(0).size()) {
				R();
			} else {
				C();
			}
			time++;
		}

		System.out.println("-1");

	}

	static void R() {

		int rowSize = map.size();
		List<List<Integer>> newMap = new ArrayList<List<Integer>>();
		int maxLen = 0;

		for (int row = 0; row < rowSize; row++) {
			Map<Integer, Integer> countMap = new HashMap<>();
			for (int col = 0; col < map.get(0).size(); col++) {
				int v = map.get(row).get(col);
				if (v == 0)
					continue;
				countMap.put(v, countMap.getOrDefault(v, 0) + 1);
			}

			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());

			list.sort((a, b) -> {
				if (!a.getValue().equals(b.getValue()))
					return a.getValue() - b.getValue();
				return a.getKey() - b.getKey();
			});

			List<Integer> newRow = new ArrayList<>();
			for (Map.Entry<Integer, Integer> e : list) {
				newRow.add(e.getKey());
				newRow.add(e.getValue());
			}
			if (newRow.size() > 100)
				newRow = newRow.subList(0, 100);
			maxLen = Math.max(maxLen, newRow.size());
			newMap.add(newRow);
		}
		maxLen = Math.min(maxLen, 100);

		for (List<Integer> row : newMap) {
			while (row.size() < maxLen) {
				row.add(0);
			}
		}

		map = newMap;
	}

	static void C() {
		int colSize = map.get(0).size();
		List<List<Integer>> newMap = new ArrayList<>();
		int maxLen = 0;

		for (int col = 0; col < colSize; col++) {

			Map<Integer, Integer> countMap = new HashMap<>();

			for (int row = 0; row < map.size(); row++) {
				int v = map.get(row).get(col);
				if (v == 0)
					continue;
				countMap.put(v, countMap.getOrDefault(v, 0) + 1);
			}

			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());

			list.sort((a, b) -> {
				if (!a.getValue().equals(b.getValue()))
					return a.getValue() - b.getValue();
				return a.getKey() - b.getKey();
			});

			List<Integer> newCol = new ArrayList<>();
			for (Map.Entry<Integer, Integer> e : list) {
				newCol.add(e.getKey());
				newCol.add(e.getValue());
			}
			if (newCol.size() > 100)
				newCol = newCol.subList(0, 100);

			newMap.add(newCol);
			maxLen = Math.max(maxLen, newCol.size());

		}
		maxLen = Math.min(maxLen, 100);

		List<List<Integer>> newMap2 = new ArrayList<>();
		for (int i = 0; i < maxLen; i++) {
			newMap2.add(new ArrayList<>());
		}

		for (List<Integer> col : newMap) {
			for (int i = 0; i < maxLen; i++) {
				if (i < col.size())
					newMap2.get(i).add(col.get(i));
				else
					newMap2.get(i).add(0);
			}
		}

		map = newMap2;
	}

}
