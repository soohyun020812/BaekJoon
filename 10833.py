# 사과 

N = int(input()) 
total_remaining_apples = 0 

for _ in range(N):
    # 학생 수와 사과 개수 입력
    students, apples = map(int, input().split()) 
    # 남은 사과 개수를 누적
    total_remaining_apples += apples % students 

print(total_remaining_apples) 