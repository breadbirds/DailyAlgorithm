import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.equals("end")) {

            boolean ans = false;
            ans = checkAEIOU(input);
            if (!ans) {
                System.out.printf("<%s> is not acceptable.\n", input);
                continue;
            }

            ans = checkContinuous(input);
            if (!ans) {
                System.out.printf("<%s> is not acceptable.\n", input);
                continue;
            }

            ans = checkSameChar(input);

            if (!ans) {
                System.out.printf("<%s> is not acceptable.\n", input);
            } else {
                System.out.printf("<%s> is acceptable.\n", input);
            }
        }
    }

    static boolean checkAEIOU(String input) {

        for (char ch : input.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }

        return false;
    }

    static boolean checkContinuous(String input) {

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length - 2; i++) {
            if (checkAEIOU(chars[i] + "") && checkAEIOU(chars[i + 1] + "") && checkAEIOU(chars[i + 2] + "")) {
                return false;
            }

            if (!checkAEIOU(chars[i] + "") && !checkAEIOU(chars[i + 1] + "") && !checkAEIOU(chars[i + 2] + "")) {
                return false;
            }
        }

        return true;
    }

    static boolean checkSameChar(String input) {

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != 'e' && chars[i] != 'o' && chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }
}