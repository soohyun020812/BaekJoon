# 팩토리얼

# factorial(계승) : 1부터 지정된 수까지 모든 수의 곱을 의미
# '!'를 숫자뒤에 붙여 표시함, 3! = 3팩토리얼(factorial)
# 3! = 1 * 2 * 3 = 6
def factorial(n):
    # N == 0이면 1반환 (0! = 1)
    if n == 0:
        return 1
    # 그렇지 않으면 N * (N-1)! 형태로 재귀 호출
    return n * factorial(n - 1)

N = int(input()) 
print(factorial(N)) 