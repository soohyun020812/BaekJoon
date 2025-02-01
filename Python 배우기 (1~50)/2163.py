# 초콜릿 자르기

# 초콜릿의 크기 입력받기
N, M = map(int, input().split())

# 최소 쪼개기 횟수는 (N-1) + (M-1) + (N-1) * (M-1) = N * M - 1
cuts = N * M - 1  

print(cuts)