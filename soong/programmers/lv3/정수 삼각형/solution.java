class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

		int n = triangle.length;
		int[][] result = new int[n][n];
		// 가장 바닥 숫자 
		for (int i = 0; i < triangle[n - 1].length; i++) {
			result[n - 1][i] = triangle[n - 1][i];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				int num = triangle[i][j];
				result[i][j] = num + Math.max(result[i + 1][j], result[i + 1][j + 1]);
			}
		}

		answer = result[0][0];
		
		return answer;
    }
}
