# 백설 공주와 일곱 난쟁이 

import sys

heights = [int(sys.stdin.readline().strip()) for _ in range(9)]

# 전체 합
total_sum = sum(heights)

# 두 명을 찾기 위한 반복문
found = False
for i in range(9):
    for j in range(i + 1, 9):
        if total_sum - (heights[i] + heights[j]) == 100:
            fake1, fake2 = heights[i], heights[j]
            found = True
            break
    if found:
        break

# 7명의 난쟁이 리스트 구성
real_dwarfs = sorted([h for h in heights if h not in (fake1, fake2)])

for h in real_dwarfs:
    print(h)