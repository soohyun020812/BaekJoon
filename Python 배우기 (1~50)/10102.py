# 개표 

# 심사위원 수
V = int(input())

# 투표 결과
votes = input()

# A와 B의 득표 수 계산
count_A = votes.count("A")
count_B = votes.count("B")

if count_A > count_B:
    print("A")
elif count_A < count_B:
    print("B")
else:
    print("Tie")