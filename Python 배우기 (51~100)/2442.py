# 별 찍기 - 5

N = int(input()) 

for i in range(1, N + 1):
    # 왼쪽 공백
    spaces = ' ' * (N - i) 
    # 별 개수
    stars = '*' * (2 * i - 1) 
    print(spaces + stars) 