# 평균

N = int(input().strip())

scores = list(map(int, input().split()))

# 최고점수 M 찾기
M = max(scores)

# 새로운 점수 변환 및 평균 계산
new_avg = sum(score / M * 100 for score in scores) / N

print(new_avg)