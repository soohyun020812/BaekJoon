# 평균 점수 

# 학생들의 점수 입력
scores = []
for _ in range(5):
    score = int(input())
    # 40점 미만인 점수는 40으로 보정
    if score < 40:
        score = 40
    scores.append(score)

# 평균 계산
average = sum(scores) // 5

print(average)