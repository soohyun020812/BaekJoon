# 카드 게임 

# 총점을 저장할 변수 초기화
total_score = 0 

for _ in range(5):
    # 각 게임의 점수
    score = int(input()) 
    # 입력 받은 점수를 총점에 합산 
    total_score += score 

print(total_score)