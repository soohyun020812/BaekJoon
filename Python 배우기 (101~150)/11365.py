# !밀비 급일 

import sys

# 입력이 여러 줄이므로 종료 조건이 나올 때까지 반복 처리
while True:
    # strip()을 사용하여 앞뒤 공백 제거
    s = sys.stdin.readline().strip() 
    # 종료 조건
    if s == "END": 
        break
    # [::-1]을 사용하여 문자열 뒤집어서 출력
    print(s[::-1]) 