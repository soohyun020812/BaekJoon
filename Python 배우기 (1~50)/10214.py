# Baseball

T = int(input()) 

for _ in range(T):
    # 연세대 총 득점
    yonsei_score = 0 
    # 고려대 총 득점
    korea_score = 0 
    
    # 9번의 회차에 대해 득점 계산
    for _ in range(9):
        # 연세대 득점, 고려대 득점 입력
        Y, K = map(int, input().split())
        yonsei_score += Y
        korea_score += K
    
    if yonsei_score > korea_score:
        print("Yonsei")
    elif yonsei_score < korea_score:
        print("Korea")
    else:
        print("Draw")