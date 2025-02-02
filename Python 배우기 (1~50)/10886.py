# 0 = not cute / 1 = cute

# 설문 조사 참여자 수
N = int(input())

# 0(귀엽지 않음)과 1(귀여움) 개수 카운트
count_0 = 0
count_1 = 0

# N번 설문 조사 결과
for _ in range(N):
    vote = int(input())
    if vote == 0:
        count_0 += 1
    else:
        count_1 += 1

# 1이 더 많으면 "Junhee is cute!" 출력
if count_1 > count_0:
    print("Junhee is cute!")
# 0이 더 많으면 "Junhee is not cute!" 출력
else:
    print("Junhee is not cute!")