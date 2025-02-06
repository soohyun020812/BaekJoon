# 별 찍기 - 8

N = int(input())

# 첫 번째 부분, 별이 증가
for i in range(1, N + 1):
    print("*" * i + " " * (2 * (N - i)) + "*" * i)

# 두 번째 부분, 별이 감소
for i in range(N - 1, 0, -1):
    print("*" * i + " " * (2 * (N - i)) + "*" * i)