# 완전제곱수 

import math

M = int(input())
N = int(input())

# 완전제곱수를 저장할 리스트
perfect_squares = []

# M 이상 N 이하의 숫자 중 완전제곱수를 찾기
for num in range(M, N + 1):
    # 제곱근을 내린 후 제곱하여 원래 값과 같은지 확인
    if math.isqrt(num) ** 2 == num:
        perfect_squares.append(num)

if perfect_squares:
    # 완전제곱수의 합
    print(sum(perfect_squares))
    # 완전제곱수 중 최솟값
    print(min(perfect_squares)) 
else:
    # 완전제곱수가 없을 경우
    print(-1)