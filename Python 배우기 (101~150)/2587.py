# 대표값2

numbers = [int(input()) for _ in range(5)]

# 평균 계산
# 항상 정수로 떨어짐
mean = sum(numbers) // 5 

# 중앙값 계산
numbers.sort()
# 중앙값은 정렬 후 세 번째 값 (index 2)
median = numbers[2] 

print(mean)
print(median)