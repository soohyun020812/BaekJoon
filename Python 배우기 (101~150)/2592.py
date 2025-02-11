# 대표값

import sys
from collections import Counter

# 10개 숫자 입력받기
numbers = [int(sys.stdin.readline().strip()) for _ in range(10)] 

# 평균 계산, 정수 나눗셈 (//) 사용
average = sum(numbers) // 10 

# 최빈값 계산
# 각 숫자의 빈도 계산
counter = Counter(numbers) 
# 가장 많이 등장한 숫자 찾기
mode = counter.most_common(1)[0][0] 

print(average)
print(mode)