package source_code;

import java.io.*;
import java.util.*;

public class B_S2_20006_RankedQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> user = new LinkedHashMap<>();
		Map<String, Integer> team = new HashMap<>();

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();

			user.put(nickname, level);
		}

		while (user.size() != 0) {
			List<String> nickname = new ArrayList<>(user.keySet());
			int idx = 0;
			boolean isTeam = true;

			while (team.size() < m) {
				if (idx >= user.size()) {
					isTeam = false;
					break;
				}

				String nick = nickname.get(idx);

				if (idx == 0 || Math.abs(user.get(nick) - team.get(nickname.get(0))) <= 10) {
					team.put(nick, user.get(nick));
				}

				idx++;
			}

			// 결과 출력
			if (isTeam == false) {
				System.out.println("Waiting!");
			} else {
				System.out.println("Started!");
			}

			// 정렬
			List<Map.Entry<String, Integer>> entryList = new ArrayList<>(team.entrySet());
			entryList.sort(Comparator.comparing(Map.Entry::getKey));

			System.out.println("Started!");

			for (Map.Entry<String, Integer> e : entryList) {
				System.out.println(e.getValue() + " " + e.getKey());
				user.remove(e.getKey());
			}

			// 삭제
			team.clear();

		}
	}

}
