# 성적 통계 

import sys

K = int(sys.stdin.readline().strip())

for i in range(1, K + 1):
    data = list(map(int, sys.stdin.readline().split()))
    # 학생 수
    N = data[0] 
    # 성적 리스트
    scores = data[1:] 

    max_score = max(scores)
    min_score = min(scores)
    
    # 점수 내림차순 정렬 후 인접한 점수 차이 계산
    scores.sort(reverse=True)
    largest_gap = max(scores[j] - scores[j + 1] for j in range(N - 1))

    print(f"Class {i}")
    print(f"Max {max_score}, Min {min_score}, Largest gap {largest_gap}")