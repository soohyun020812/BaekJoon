# 별 찍기 - 2

N = int(input())

for i in range(1, N + 1):
    # " " * (N - i) : 왼쪽 공백을 N - i만큼 추가
    print(" " * (N - i) + "*" * i)