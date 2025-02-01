# 수들의 합

S = int(input())

# 변수 초기화
sum = 0
N = 0

# N을 증가시키며 합을 구함
while sum <= S:
    N += 1
    sum += N

# 최댓값 N은 마지막에 sum이 S를 초과하는 N-1
print(N - 1)