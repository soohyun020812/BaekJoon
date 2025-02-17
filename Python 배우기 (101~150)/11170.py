# 0의 개수 

import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    N, M = map(int, sys.stdin.readline().split()) 
    # 0의 개수를 저장할 변수
    count = 0 
    
    # N부터 M까지의 숫자를 문자열로 변환 후 0 개수 세기
    for num in range(N, M + 1):
        count += str(num).count('0')
    
    print(count) 