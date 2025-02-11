# 지능형 기차 2

# 기차 안의 최대 인원
max_people = 0 
# 현재 기차 안의 인원
current_people = 0 

for _ in range(10):
    out_people, in_people = map(int, input().split())
    # 내린 사람 빼기
    current_people -= out_people 
    # 탄 사람 더하기
    current_people += in_people 
    # 최대 인원 업데이트
    max_people = max(max_people, current_people) 

print(max_people)