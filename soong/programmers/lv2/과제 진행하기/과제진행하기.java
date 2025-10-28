import java.util.*;
class Solution {
    static class Sub {
		int time;
		String name;

		Sub(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
    
    public static String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];

		// 시간 순으로 정렬
		Arrays.sort(plans, (a, b) -> {
			int timeA = toMinutes(a[1]);
			int timeB = toMinutes(b[1]);
			return timeA - timeB;
		});

		Stack<Sub> st = new Stack<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < plans.length - 1; i++) {
			int startTime = toMinutes(plans[i][1]);
			int duration = Integer.parseInt(plans[i][2]);
			int endTime = startTime + duration;

			int nextStart = toMinutes(plans[i + 1][1]);

			if (endTime > nextStart) { // 덜 끝냄
				st.push(new Sub(plans[i][0], endTime - nextStart));
			} else {
				result.add(plans[i][0]);

				int remainTime = nextStart - endTime;
				while (!st.isEmpty() && remainTime > 0) {
					Sub paused = st.pop();
					if (paused.time <= remainTime) {
						result.add(paused.name);
						remainTime -= paused.time;
					} else { // 여전히 덜 끝났을 때
						st.push(new Sub(paused.name, paused.time - remainTime));
						break;
					}
				}
			}
		}

		result.add(plans[plans.length - 1][0]);
		while (!st.isEmpty()) {
			result.add(st.pop().name);
		}
		// System.out.println(result);

        int idx = 0;
        for(String name: result) {
            answer[idx++] = name;
        }
		return answer;
	}

	static int toMinutes(String time) {

		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[1]);

		return hour * 60 + min;
	}
}
