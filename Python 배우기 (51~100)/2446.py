# 별 찍기 - 9

N = int(input())

# 첫 번째 부분, 별이 감소 
for i in range(N):
    print(" " * i + "*" * (2 * (N - i) - 1))

# 두 번째 부분, 별이 증가 
for i in range(N - 2, -1, -1):
    print(" " * i + "*" * (2 * (N - i) - 1))