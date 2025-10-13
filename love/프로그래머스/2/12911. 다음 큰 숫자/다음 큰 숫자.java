import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int smallest = n & -n;              // LSB 1
        int ripple   = n + smallest;        // 오른쪽 블록 올림
        int ones     = n ^ ripple;          // 변화분(사라진 1들의 정보)
        ones = (ones >>> 2) / smallest;     // 사라진 1들을 오른쪽 끝으로
        return ripple | ones;
    }
}