# 플러그 

import sys

input_data = sys.stdin.read()

# 입력 데이터를 줄 단위로 나누기
lines = input_data.splitlines()

# 멀티탭의 개수 N
N = int(lines[0])

# 연결할 수 있는 컴퓨터의 수를 누적하여 저장
max_computers = 0

# 각 멀티탭의 플러그 수
for i in range(1, N + 1):
    # 각 멀티탭의 플러그 수를 가져옴
    plugs = int(lines[i]) 
    # 플러그 수를 누적하여 합산산
    max_computers += plugs 

# 첫 번째 멀티탭을 제외한 나머지 멀티탭에서 1개씩 빼야 함 (N-1만큼 빼기)
max_computers -= (N - 1)

# 최대로 연결할 수 있는 컴퓨터 수
print(max_computers)

'''
시간 초과 문제 해결
input 말고 sys.stdin 사용

input : 한 줄씩 입력 받음
sys.stdin : 여러 줄의 입력을 한 번에 읽을 수 있음
'''