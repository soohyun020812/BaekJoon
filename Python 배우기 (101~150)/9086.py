# 문자열 

import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    # 문자열 입력
    s = sys.stdin.readline().strip() 
    # 첫 글자와 마지막 글자 출력
    print(s[0] + s[-1]) 