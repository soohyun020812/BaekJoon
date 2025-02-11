# 나는 요리사다 

# 최고 점수
max_score = 0 
# 최고 점수
winner = 0 

# 1번 참가자부터 5번 참가자까지
for i in range(1, 6): 
    scores = list(map(int, input().split())) 
    total = sum(scores) 
    
    # 현재 최고 점수보다 크면 업데이트
    if total > max_score: 
        max_score = total
        # 참가자 번호 저장
        winner = i 

print(winner, max_score) 