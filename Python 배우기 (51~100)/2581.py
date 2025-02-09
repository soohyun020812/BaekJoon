# 소수 

import sys
import math

# 소수 판별 함수
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

M = int(sys.stdin.readline().strip())
N = int(sys.stdin.readline().strip())

# M 이상 N 이하의 소수 찾기
primes = [num for num in range(M, N + 1) if is_prime(num)]

if primes:
    # 소수들의 합
    print(sum(primes)) 
    # 소수 중 최솟값
    print(min(primes)) 
else:
    # 소수가 없을 경우
    print(-1) 