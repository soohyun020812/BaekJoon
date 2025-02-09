# 최댓값 

import sys

numbers = [int(sys.stdin.readline().strip()) for _ in range(9)]

# 최댓값 및 해당 위치 찾기
max_value = max(numbers)
# 1-based index
max_index = numbers.index(max_value) + 1 

print(max_value)
print(max_index)