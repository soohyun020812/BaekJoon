# 쉽게 푸는 문제 

# 구간 A, B 입력받기
A, B = map(int, input().split()) 

# 수열을 저장할 리스트
sequence = [] 
# 반복할 숫자
num = 1 

# B번째 숫자까지 생성해야 함
while len(sequence) < B: 
    # 숫자 num을 num번 리스트에 추가
    sequence.extend([num] * num) 
    # 다음 숫자로 이동
    num += 1 

# A-1부터 B까지의 합 출력
print(sum(sequence[A-1:B])) 