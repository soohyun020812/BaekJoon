# 짝수를 찾아라 

import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    # 7개의 숫자 입력
    numbers = list(map(int, sys.stdin.readline().split())) 
    # 짝수 필터링
    even_numbers = [num for num in numbers if num % 2 == 0] 
    
    print(sum(even_numbers), min(even_numbers))