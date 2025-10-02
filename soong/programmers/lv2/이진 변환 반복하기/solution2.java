class Solution {
    public int[] solution(String s) {
        int zero = 0;
		int cnt = 0;
		while (!s.equals("1")) {
            
            int size = s.length();
            s = s.replaceAll("0", "");
            zero += size - s.length();
            
			s = binary(s.length());
			cnt++;
		}
		System.out.println(zero);
		return new int[] {cnt ,zero };
    }
    
    static String binary(int num) {
        
        return Integer.toBinaryString(num);
    }
}