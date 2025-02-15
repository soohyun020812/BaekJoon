# 피보나치 수 5 

def fibonacci(n):
    # n이 0이면 0을 반환
    if n == 0:
        return 0
    # n이 1이면 1을 반환
    elif n == 1:
        return 1
    
    # F(0) = 0, F(1) = 1을 초기값으로 설정
    a, b = 0, 1

    # F(n) = F(n-1) + F(n-2)를 반복문으로 구현
    for _ in range(n - 1):
        a, b = b, a + b
    
    return b

n = int(input().strip())

print(fibonacci(n))