# 얼마?

T = int(input())

for _ in range(T):
    # 자동차 기본 가격 
    s = int(input())
    
    # 옵션 개수 
    n = int(input())
    
    # 옵션 가격 합산
    total_price = s
    for _ in range(n):
        q, p = map(int, input().split())
        # 옵션 가격 추가
        total_price += q * p 
    
    print(total_price)