# 단어 공부 

import sys

# 대소문자 구분하지 않도록 소문자로 변환
word = sys.stdin.readline().strip().upper()

# 알파벳 개수 저장할 딕셔너리
alphabet_count = {}

for char in word:
    if char in alphabet_count:
        alphabet_count[char] += 1
    else:
        alphabet_count[char] = 1

# 최다 빈도 알파벳 찾기
# 가장 많이 나온 횟수
max_count = max(alphabet_count.values()) 
max_chars = [key for key, value in alphabet_count.items() if value == max_count]

# 최다 빈도 알파벳이 1개면 출력, 여러 개면 '?'
print(max_chars[0] if len(max_chars) == 1 else '?')