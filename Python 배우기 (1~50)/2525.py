# 오븐 시계 

# 현재 시각 A, B 입력
A, B = map(int, input().split())

# 요리하는 데 필요한 시간 C 입력
C = int(input())

# 총 걸리는 시간을 분 단위로 계산
total_minutes = A * 60 + B + C

# 종료되는 시각 계산
# 24시간 형식 적용
end_hour = (total_minutes // 60) % 24 
end_minute = total_minutes % 60

print(end_hour, end_minute)