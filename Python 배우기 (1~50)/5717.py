# 상근이의 친구들 

while True:
    M, F = map(int, input().split())
    
    # 종료 조건
    if M == 0 and F == 0: 
        break
    
    print(M + F)