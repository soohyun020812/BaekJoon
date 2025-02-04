# 별 찍기 - 4 

N = int(input())

for i in range(N, 0, -1):
    # " " * (N - i) : 왼쪽 공백을 N - i만큼 추가
    print(" " * (N - i) + "*" * i)