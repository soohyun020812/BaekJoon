# OX퀴즈

# 테스트 케이스 개수 입력
n = int(input()) 

for _ in range(n):
    quiz = input().strip() 
    total_score = 0 
    # 연속된 O의 개수 (점수 계산용)
    count = 0 

    for ch in quiz:
        if ch == 'O':
            # 연속된 O 개수 증가
            count += 1 
            # 누적 점수 추가
            total_score += count 
        else:
            # X가 나오면 연속 개수 초기화
            count = 0 

    print(total_score)