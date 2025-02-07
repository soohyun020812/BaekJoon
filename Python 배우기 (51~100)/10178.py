# 할로윈의 사탕 

t = int(input())

for _ in range(t):
    # 사탕 개수와 형제 수 입력
    c, v = map(int, input().split())
    
    # 각 형제가 받는 사탕의 개수
    candies_per_sibling = c // v
    # 아버지가 받는 남은 사탕
    candies_for_dad = c % v
    
    print(f"You get {candies_per_sibling} piece(s) and your dad gets {candies_for_dad} piece(s).")