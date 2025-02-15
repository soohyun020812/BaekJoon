# 동전 0 

# 동전 종류 수 n, 목표 금액 k
n, k = map(int, input().split()) 
# 동전 가치 리스트
coins = [int(input()) for _ in range(n)] 

count = 0 

# 가치가 큰 동전부터 사용
for coin in reversed(coins): 
    # 현재 동전을 사용할 수 있는 경우
    if k >= coin: 
        # 해당 동전으로 몇 개 사용 가능한지 계산
        count += k // coin 
        # 남은 금액 갱신
        k %= coin 

print(count) 