# 주사위 게임 

n = int(input()) 
# 창영과 상덕의 초기 점수
score_c, score_s = 100, 100 

for _ in range(n):
    c, s = map(int, input().split()) 
    # 창영이 주사위가 작을 경우
    if c < s: 
        score_c -= s
    # 상덕이 주사위가 작을 경우
    elif c > s: 
        score_s -= c

# 최종 창영이 점수
print(score_c) 
# 최종 상덕이 점수
print(score_s) 