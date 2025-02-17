# 열 개씩 끊어 출력하기

word = input().strip()

for i in range(0, len(word), 10):
    # [i:i+10] : i번째 문자부터 i+10번째 문자까지 출력 
    print(word[i:i+10])