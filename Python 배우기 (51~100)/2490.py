# 윷놀이 

import sys

for _ in range(3): 
    # 윷 상태 입력
    yut = list(map(int, sys.stdin.readline().split())) 
    # 배(0)의 개수 세기
    count_0 = yut.count(0) 
    
    if count_0 == 1:
        # 도
        print("A") 
    elif count_0 == 2:
        # 개
        print("B") 
    elif count_0 == 3:
        # 걸
        print("C") 
    elif count_0 == 4:
        # 윷
        print("D") 
    else:
        # 모
        print("E") 