# Yangjojang of The Year

T = int(input())

for _ in range(T):
    N = int(input())
    # 최대 술 소비량 (초기값은 매우 작은 값) 
    max_liquor = -1 
    # 가장 술을 많이 소비한 학교 이름
    best_school = "" 
    
    for _ in range(N):
        school, liquor = input().split() 
        liquor = int(liquor) 
        
        # 술 소비량이 더 많으면 업데이트
        if liquor > max_liquor:
            max_liquor = liquor
            best_school = school
    
    print(best_school)