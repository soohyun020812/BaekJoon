# 알람 시계 

H, M = map(int, input().split())

# 45분 일찍 설정
M -= 45

# 만약 분(M)이 0보다 작다면, 시간을 조정
if M < 0:
    M += 60
    H -= 1

    # 만약 시간이 0보다 작다면 23시로 변경
    if H < 0:
        H = 23

print(H, M)