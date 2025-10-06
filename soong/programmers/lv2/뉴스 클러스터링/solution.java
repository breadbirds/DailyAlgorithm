
import java.util.*;

class Solution {

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Stack<String> strChar1 = new Stack<>();
        Stack<String> strChar2 = new Stack<>();

        String tmp = "";
        for (char c : str1.toCharArray()) {
            if (c == ' ' || c < 97 || c > 122) {
                tmp = "";
                continue;
            }
            tmp += c + "";
            if (tmp.length() == 2) {
                strChar1.add(tmp);
                tmp = c + "";
            }
        }

        tmp = "";
        for (char c : str2.toCharArray()) {
            if (c == ' ' || c < 97 || c > 122) {
                tmp = "";
                continue;
            }
            tmp += c + "";
            if (tmp.length() == 2) {
                strChar2.add(tmp);
                tmp = c + "";
            }
        }

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < strChar1.size(); i++) {
            String key = strChar1.get(i);
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < strChar2.size(); i++) {
            String key = strChar2.get(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        int top = 0, down = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {  // map2에 같은 원소가 있음
                top += Math.min(map2.get(key), map1.get(key));
                down += Math.max(map2.get(key), map1.get(key));
            } else {
                top += 0;
                down += map1.get(key);
            }

        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                down += map2.get(key);
            }
        }

        if (top >= 0 && down > 0) {
            return (int) (top * 65536 / down);
        } return 65536;
    }
}
