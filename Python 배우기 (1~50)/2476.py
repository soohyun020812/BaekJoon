# 주사위 게임 

# 참가자 수
N = int(input())
# 최댓값 저장 변수 
max_prize = 0 

for _ in range(N):
    a, b, c = map(int, input().split())
    
    # 같은 눈 3개
    if a == b == c:
        prize = 10_000 + a * 1_000
    # 같은 눈 2개
    elif a == b or a == c:
        prize = 1_000 + a * 100
    elif b == c:
        prize = 1_000 + b * 100
    # 모두 다른 눈
    else:
        prize = max(a, b, c) * 100

    # 최댓값 갱신
    max_prize = max(max_prize, prize)

print(max_prize)