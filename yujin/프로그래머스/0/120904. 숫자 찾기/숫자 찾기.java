class Solution {
    public int solution(int num, int k) {
        int answer = 0;

		char arr[] = String.valueOf(num).toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k + '0') {
				return  i + 1;
			} 
		}
		

		return -1;
	}
}