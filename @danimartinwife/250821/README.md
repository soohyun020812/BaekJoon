### 괄호 추가하기 3 - 코드 접근법 비교

**이전코드 : DFS + 괄호 배치 방식**
``` python
def dfs(idx, expr):
    if idx >= len(expr):
        answer = max(answer, evaluate(expr))
        return

    # 괄호를 추가하지 않고 다음으로 진행
    dfs(idx+2, expr)

    # 괄호를 추가해서 계산
    if idx+2 < len(expr):
        sub = str(evaluate(expr[idx:idx+3]))
        dfs(idx+4, expr[:idx] + sub + expr[idx+3:])
```

**문제점**
1. 괄호 배치 누락 발생
- 8*3+5+2 → (8*3)+(5+2) 같은 괄호 조합을 고려하지 못해서 답이 66이 나옴
2. 탐색 범위 축소
- idx+2, idx+4 식으로 탐색을 건너뛰다 보니 가능한 연산 순서 일부가 DFS 경로에서 제외됨
3. 정답 불일치
- 예제 3, 4, 6에서 오답 = 괄호 배치 DFS가 완전하지 않음을 의미

**구글 검색 후 정답 코드 : 모든 연산 순서 탐색 방식**
``` python
matcher = {'*': operator.mul, '+': operator.add, '-': operator.sub}
digits = list(map(int, re.findall(r'\d', stdin.readline().strip())))
ops = list(re.findall(r'\D', stdin.readline().strip()))[:-1]
answer = []

def calc(nums, operators):
    # 숫자가 하나만 남으면 결과 완성
    if len(nums) == 1:
        answer.append(nums[0])
        return

    # 모든 연산자 위치에 대해 연산을 수행
    for i in range(len(operators)):
        new_nums = nums[:i] + [matcher[operators[i]](nums[i], nums[i+1])] + nums[i+2:]
        new_ops = operators[:i] + operators[i+1:]
        calc(new_nums, new_ops)

calc(digits, ops)
print(max(answer))
```

**해결된 점**
1. 모든 연산 순서를 전부 탐색
- 괄호 배치를 직접 시뮬레이션 하지 않고 연산사 적용 순서를 전부 경우의 수로 탐색
2. 중첩 괄호 자동 처리
- DFS가 연산자 i번째 먼저 계산을 반복하여 중첩 괄호/멀리 떨어진 괄호 조합도 포함됨
3. 정답 보장
- 탐색이 완전하여 오답 발생하지 않음

| 항목 | 이전 코드 (괄호 DFS)          | 새 코드 (연산 순서 DFS)   |
| -- | ----------------------- | ------------------ |
| 접근 | 괄호 배치 DFS               | 연산 순서 DFS          |
| 장점 | 상대적으로 빠름                | 모든 경우 보장, 정답 100%  |
| 단점 | 중첩/멀리 떨어진 괄호 놓침 → 오답 발생 | 경우의 수 많아져서 느릴 수 있음 |
| 결과 | 일부 테스트 오답               | 모든 테스트 정답          |

