class Solution {
    public int[] solution(int n, long left, long right) {
       int len = (int)(right - left + 1);
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            long idx = left + i;        // 전체 중 i번째 인덱스
            int row = (int)(idx / n);   // 가상의 행
            int col = (int)(idx % n);   // 가상의 열
            result[i] = Math.max(row, col) + 1; // 실제 값 계산
        }
        return result;
    }
}