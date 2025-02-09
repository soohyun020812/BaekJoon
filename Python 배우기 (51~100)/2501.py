# 약수 구하기 

import sys

N, K = map(int, sys.stdin.readline().split())

# 약수 리스트 구하기
divisors = [i for i in range(1, N + 1) if N % i == 0]

# K번째 약수 출력 
# 0-based index이므로 K-1 사용
if len(divisors) >= K:
    print(divisors[K - 1])
else:
    print(0)