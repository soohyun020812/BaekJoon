# 별 찍기 - 6

N = int(input()) 

for i in range(N):
    # 왼쪽 공백
    spaces = ' ' * i 
    # 별 개수
    stars = '*' * (2 * (N - i) - 1) 
    print(spaces + stars) 