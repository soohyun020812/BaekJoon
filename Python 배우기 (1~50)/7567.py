# 그릇 

bowls = input()

# 첫 번째 그릇의 높이는 10cm
height = 10

# 이전 그릇의 방향을 저장
prev = bowls[0]

# 두 번째 그릇부터 이전 그릇(prev)과 비교
for i in range(1, len(bowls)):
    # 같은 방향이면 5cm 증가
    if bowls[i] == prev: 
        height += 5
    # 반대 방향이면 10cm 증가
    else: 
        height += 10
    # 이전 그릇 갱신
    prev = bowls[i] 

print(height)