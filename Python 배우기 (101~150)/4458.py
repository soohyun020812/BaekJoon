# 첫 글자를 대문자로 

# 입력 받기
N = int(input()) 

# N개의 문장 입력 및 처리
for _ in range(N):
    sentence = input() 
    # 첫 글자를 대문자로 변환하여 출력
    print(sentence[0].upper() + sentence[1:]) 