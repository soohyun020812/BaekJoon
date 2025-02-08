# 별 찍기 - 16

# 입력값을 정수로 변환
N = int(input().strip()) 

# N번 반복하며 별 출력
for i in range(N):
    print(" " * (N - i - 1) + "* " * (i + 1))