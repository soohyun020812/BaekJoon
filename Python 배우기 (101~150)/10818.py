# 최소, 최대 

N = int(input())

# 둘째 줄에 N개의 정수가 공백으로 구분되어 입력
numbers = list(map(int, input().split()))

# 최솟값과 최댓값 
min_value = min(numbers)
max_value = max(numbers)

print(min_value, max_value)