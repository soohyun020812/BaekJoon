# 콘테스트

# 참가자 10명의 점수를 입력 후 상위 3명의 점수를 합산
def top_3_sum(scores):
    return sum(sorted(scores, reverse=True)[:3])

# W 대학 점수 입력
w_scores = [int(input().strip()) for _ in range(10)]

# K 대학 점수 입력
k_scores = [int(input().strip()) for _ in range(10)]

# 각 대학의 상위 3명 점수 합산
w_total = top_3_sum(w_scores)
k_total = top_3_sum(k_scores)

print(w_total, k_total)