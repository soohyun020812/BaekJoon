# 인공지능 시계 

# 현재 시각 입력 (시, 분, 초)
A, B, C = map(int, input().split())

# 요리하는 데 필요한 시간 입력 (초 단위)
D = int(input())

# 현재 시간을 초 단위로 변환 후 요리 시간을 추가
total_seconds = A * 3600 + B * 60 + C + D

# 종료되는 시각 계산
# 24시간 형식 적용
end_hour = (total_seconds // 3600) % 24 
end_minute = (total_seconds % 3600) // 60
end_second = total_seconds % 60

print(end_hour, end_minute, end_second)