# 오타맨 고창영

T = int(input()) 

for _ in range(T):
    # 입력 받기 (오타 위치, 문자열)
    idx, word = input().split() 
    # 1-based index를 0-based index로 변환
    idx = int(idx) 
    print(word[:idx-1] + word[idx:]) 