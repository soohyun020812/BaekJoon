# 지능형 기차

# 변수 초기화
current_passengers = 0
max_passengers = 0

for _ in range(4):
    out_count, in_count = map(int, input().split())
    # 내린 사람 제거
    current_passengers -= out_count 
    # 탄 사람 추가
    current_passengers += in_count  
    # 최대값 갱신
    max_passengers = max(max_passengers, current_passengers) 

print(max_passengers)