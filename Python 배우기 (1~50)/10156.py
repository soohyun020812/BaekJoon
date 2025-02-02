# 과자 

K, N, M = map(int, input().split())

# 필요한 총 금액 계산
total_cost = K * N

# 부모님께 받아야 하는 금액 계산
money = max(0, total_cost - M)

print(money)