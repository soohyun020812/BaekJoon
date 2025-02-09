# 피보나치 수 

N = int(input())

# F(0) = 0, F(1) = 1
a, b = 0, 1

for _ in range(N):
    # 다음 피보나치 수 계산
    a, b = b, a + b 

print(a)

'''
Memoization (메모이제이션)

N = int(input())

dp = [0] * (N+1)
dp[1] = 1

for i in range(2, N+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[N])
'''