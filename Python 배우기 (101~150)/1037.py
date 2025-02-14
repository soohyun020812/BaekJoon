# 약수 

k = int(input()) 
# 진짜 약수 리스트
divisors = list(map(int, input().split())) 

# 원래 수 N 계산
N = min(divisors) * max(divisors)

print(N)