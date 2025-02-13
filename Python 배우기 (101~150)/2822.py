# 점수 계산 

scores = []

for i in range(8):
    score = int(input())
    # (점수, 문제 번호) 튜플로 저장
    scores.append((score, i + 1)) 

# 점수 내림차순 정렬
scores.sort(reverse=True, key=lambda x: x[0])

# 가장 높은 5개의 점수 선택
top_5_scores = scores[:5]

# 점수 합산
total_score = sum(score for score, _ in top_5_scores)

# 문제 번호 오름차순 정렬
problem_numbers = sorted([problem for _, problem in top_5_scores])

print(total_score)
print(" ".join(map(str, problem_numbers)))