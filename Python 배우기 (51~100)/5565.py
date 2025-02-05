# 영수증 

total_price = int(input()) 
# 9권 가격 합 계산
sum_known_prices = sum(int(input()) for _ in range(9)) 
print(total_price - sum_known_prices) 