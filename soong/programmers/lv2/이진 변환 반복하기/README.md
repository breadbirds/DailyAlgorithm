
# [프로그래머스 - lv2] 이진 변환 반복하기

## ⏰  **time**
20분


## ⏲️**Time Complexity**
$O(N^2)$

## 풀이 1
직접 모두 구현해서 사용

```java
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
```

## 풀이 2

라이브러리 사용해 풀이
- `replaceAll` : 값을 바꿀 수 있음
- `Integer.toBinaryString(num)` : `num`의 수를 이진수로 변환해주는 함수
  
```java
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
```



## :black_nib: **Review**




## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/70129

