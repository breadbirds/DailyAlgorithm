import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Double> fail = new HashMap<>();
        int[] result = new int[N];

        // 스테이지별 도달하지 못한 사람 
        int stage = 1;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < stages.length; j++) {
                if (stages[j] == stage) {
                    cnt++;
                }
            }

            map.put(stage, cnt);
            stage++;
        }


        int total = stages.length;
        for(int key: map.keySet()) {
            int nonClear = map.get(key);
            if (total > 0) {
                fail.put(key, (double) nonClear / total);
            } else {
                fail.put(key, 0.0);
            }
            total -= nonClear;
        }

        List<Integer> keySet = new ArrayList<>(fail.keySet());
        keySet.sort((o1, o2) -> {
            int cmp = fail.get(o2).compareTo(fail.get(o1));
            if (cmp == 0) {
                return o1.compareTo(o2);  // 값이 같으면 key를 오름차순
            }
            return cmp;
        });

        int idx = 0;
        for (int key : keySet) {
            result[idx++] = key;
        }

        return result;
    }
}
