import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        // 초기화
        int answer = 0;
    	int maxCnt = nums.length/2;

    	// 중복 제거
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i=0; i<nums.length; i++) {
    		set.add(nums[i]);
    	}
    	
    	// Result
        return set.size() > maxCnt ? maxCnt : set.size();
    }
}