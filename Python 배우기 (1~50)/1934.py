# 최소공배수 

import math

# 테스트 케이스 수 입력
T = int(input())

# 각 테스트 케이스에 대해 최소공배수 계산
for _ in range(T):
    A, B = map(int, input().split())
    # 최소공배수 계산 : (A * B) // GCD(A, B)
    lcm = (A * B) // math.gcd(A, B)
    print(lcm)