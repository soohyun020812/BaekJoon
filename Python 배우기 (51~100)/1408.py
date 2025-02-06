# 24

import sys

# 시간을 초 단위로 변환하는 함수
def time_to_seconds(time_str):
    h, m, s = map(int, time_str.split(":"))
    return h * 3600 + m * 60 + s

# 초를 다시 시간 형식으로 변환하는 함수
def seconds_to_time(seconds):
    h = seconds // 3600
    m = (seconds % 3600) // 60
    s = seconds % 60
    return f"{h:02}:{m:02}:{s:02}"

current_time = sys.stdin.readline().strip()
start_time = sys.stdin.readline().strip()

# 초 단위로 변환
current_seconds = time_to_seconds(current_time)
start_seconds = time_to_seconds(start_time)

# 남은 시간 계산
if start_seconds > current_seconds:
    remaining_seconds = start_seconds - current_seconds
else:
    remaining_seconds = (24 * 3600 - current_seconds) + start_seconds

print(seconds_to_time(remaining_seconds))

'''
다른 풀이 코드드

# 현재 시간
h1, m1, s1 = map(int, input().split(":")) 
# 임무 시작 시간
h2, m2, s2 = map(int, input().split(":")) 

# 초 단위 변환
t1 = h1 * 3600 + m1 * 60 + s1
t2 = h2 * 3600 + m2 * 60 + s2

# 남은 시간 계산 (하루(86400초) 고려)
remaining = (t2 - t1) % 86400  

# 시, 분, 초 변환 및 출력
h = remaining // 3600
m = (remaining % 3600) // 60
s = remaining % 60

print(f"{h:02}:{m:02}:{s:02}")
'''
