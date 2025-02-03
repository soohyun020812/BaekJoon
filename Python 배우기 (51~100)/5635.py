# 생일 

import sys

n = int(sys.stdin.readline().strip())
students = []

for _ in range(n):
    data = sys.stdin.readline().strip().split()
    name = data[0]
    day, month, year = map(int, data[1:])
    # 연, 월, 일 기준으로 저장
    students.append((year, month, day, name)) 

# 나이가 많은 순으로 정렬 (연도가 작을수록 나이가 많음)
students.sort()

# 가장 나이가 적은 사람 
print(students[-1][3])

# 가장 나이가 많은 사람 
print(students[0][3])