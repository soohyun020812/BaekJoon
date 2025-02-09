# 검증수 

numbers = list(map(int, input().split()))

# 각 숫자의 제곱 합
sum_of_squares = sum(num ** 2 for num in numbers)

# 10으로 나눈 나머지 출력
print(sum_of_squares % 10)