# 내 학점을 구해줘 

T = int(input()) 

for _ in range(T):
    # 해당 학기의 과목 수
    N = int(input()) 
    # 총 학점
    total_credits = 0 
    # (학점 × 성적)의 총합
    total_score = 0 

    for _ in range(N):
        C, G = input().split()
        # 학점 (정수)
        C = int(C) 
        # 성적 (소수 가능)
        G = float(G) 

        total_credits += C
        total_score += C * G

    gpa = total_score / total_credits 
    print(total_credits, round(gpa, 1)) 