import java.util.*;
class Solution {
    public String solution(String s) {
  
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        return min + " " + max;
    }
}