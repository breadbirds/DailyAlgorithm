
# [백준- S3] 12789. 도키도키 간식드리미

## ⏰  **time**
30분

## :pushpin: **Algorithm**
Stack

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. `ans`가 간식을 받은 학생 번호이고, 1부터 순서대로 진행한다.
2. 만약 `nums[i]`가 `ans`와 같으면 `ans + 1`을 하고 같지 않으면 스택에 넣는다.
3. 만약 스택에 넣었는데, 스택의 가장 `top`이 `ans`와 같다면 stack에서 꺼내고 `ans + 1`을 한다.
4. 위 과정이 끝났을 때 `students` 스택이 비어있으면 "Nice", 아니면 "Sad"를 출력한다.

```java
Stack<Integer> students = new Stack<>();
int ans = 1;
for (int i = 0; i < n; i++) {
	nums[i] = Integer.parseInt(split[i]);
	if (ans == nums[i]) {
		ans++;
	} else {
		students.add(nums[i]);
	}
	if (!students.isEmpty() && students.peek() == ans) {
		while (!students.isEmpty() && students.peek() == ans) {
			students.pop();
			ans++;
		}
	}
}

while (!students.isEmpty()) {
	int num = students.pop();
	if (num == ans) {
		ans++;
	} else {
		break;
	}
}
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/12789

