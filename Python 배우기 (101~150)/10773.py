# 제로 

import sys

K = int(sys.stdin.readline().strip()) 
# 숫자를 저장할 스택
stack = [] 

for _ in range(K):
    num = int(sys.stdin.readline().strip()) 
    if num == 0:
        # 가장 최근에 추가된 숫자 제거
        stack.pop() 
    else:
        # 숫자를 스택에 추가
        stack.append(num) 

# 스택에 남은 숫자들의 합 출력
print(sum(stack)) 