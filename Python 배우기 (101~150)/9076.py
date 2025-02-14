# 점수 집계 

T = int(input()) 

for _ in range(T):
    # 5개의 점수 입력
    scores = list(map(int, input().split())) 
    # 점수 정렬
    scores.sort() 

# 최솟값과 최댓값 제거한 3개 점수
    middle_scores = scores[1:4] 
    if max(middle_scores) - min(middle_scores) >= 4:
        print("KIN")
    else:
        # 3개 점수의 합 출력
        print(sum(middle_scores)) 