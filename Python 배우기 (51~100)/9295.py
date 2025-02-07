# 주사위 

T = int(input())

for i in range(1, T + 1):
    # 두 주사위 던진 결과 입력
    a, b = map(int, input().split())
    
    print(f"Case {i}: {a + b}")