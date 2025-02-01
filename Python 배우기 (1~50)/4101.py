# 크냐?

while True:
    a, b = map(int, input().split())
    
    # 0 0이 들어오면 종료
    if a == 0 and b == 0:
        break
    
    # 첫 번째 수가 두 번째 수보다 크면 Yes, 아니면 No
    if a > b:
        print("Yes")
    else:
        print("No")