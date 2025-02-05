# A+B - 5

while True:
    A, B = map(int, input().split()) 
    # 0 0 입력되면 종료
    if A == 0 and B == 0: 
        break
    print(A + B) 