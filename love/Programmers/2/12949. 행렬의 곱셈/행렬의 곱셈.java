class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;      // arr2.length 와 같음
        int k = arr2[0].length;

        int[][] res = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int mid = 0; mid < m; mid++) {
                int a = arr1[i][mid];

                for (int j = 0; j < k; j++) {
                    res[i][j] += a * arr2[mid][j];
                }
            }
        }
        return res;
    }
}
