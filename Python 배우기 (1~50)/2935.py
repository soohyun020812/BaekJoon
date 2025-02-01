# 소음 

# 첫 번째 수 A 입력 받기
A = int(input())

# 연산자 + 또는 * 입력 받기
operator = input()

# 두 번째 수 B 입력 받기
B = int(input())

# 연산자에 맞는 연산 수행
if operator == '+':
    result = A + B
elif operator == '*':
    result = A * B

print(result)