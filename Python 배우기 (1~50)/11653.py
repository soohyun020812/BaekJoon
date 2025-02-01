# 소인수분해 

import math

# 정수 N 입력
N = int(input())

# 2부터 시작하여 N의 소인수들 찾기
if N > 1:
    for i in range(2, int(math.sqrt(N)) + 1):
        # i로 나눠지면 출력하고 나누기
        while N % i == 0: 
            print(i)
            N //= i

    # 남은 N이 1보다 크면 그 자체가 소수이므로 출력
    if N > 1:
        print(N)