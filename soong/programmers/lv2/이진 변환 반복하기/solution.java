class Solution {
    public int[] solution(String s) {
       int zero = 0;
		int cnt = 0;
		while (!s.equals("1")) {

			String string = "";
			for (char chr : s.toCharArray()) {
				if (chr == '0') {
					zero++;
				} else {
					string += chr;
				}
			}

			int num = string.length();
			s = binary(num);
			cnt++;
		}
		System.out.println(zero);
		return new int[] {cnt ,zero };
    }
    
    static String binary(int num) {
        
        String bin = "";
        
        while(num > 0) {
            if (num % 2 == 0) {
                bin += "0";
            } else {
                bin += "1";
            }
            num /= 2;
        }
        
        return bin;
    }
}