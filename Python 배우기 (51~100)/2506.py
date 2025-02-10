# 점수계산 

N = int(input().strip())

# 채점 결과 입력 (0 또는 1)
answers = list(map(int, input().split()))

# 총 점수와 연속 정답 카운트 변수 초기화
total_score = 0
streak = 0

# 채점 결과 순회하면서 점수 계산
for ans in answers:
    # 정답일 경우
    if ans == 1: 
        streak += 1
        total_score += streak
    # 오답일 경우
    else: 
        streak = 0

print(total_score)