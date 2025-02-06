# 별 찍기 - 7 

N = int(input())

# 위쪽 삼각형 
for i in range(1, N + 1):
    print(' ' * (N - i) + '*' * (2 * i - 1))

# 아래쪽 역삼각형
for i in range(N - 1, 0, -1):
    print(' ' * (N - i) + '*' * (2 * i - 1))