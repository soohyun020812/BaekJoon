# A+B - 6

T = int(input())

for _ in range(T):
    # A와 B를 ',' 기준으로 분리하여 정수로 변환
    A, B = map(int, input().split(','))
    
    print(A + B)