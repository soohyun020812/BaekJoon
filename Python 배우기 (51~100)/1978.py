# 소수 찾기 

def is_prime(n):
    if n < 2:
        return False
    # √n까지만 확인
    for i in range(2, int(n ** 0.5) + 1): 
        if n % i == 0:
            return False
    return True

N = int(input()) 
numbers = list(map(int, input().split())) 

# 소수 개수
prime_count = sum(1 for num in numbers if is_prime(num))
print(prime_count)