# 알파벳 찾기 

import sys

s = sys.stdin.readline().strip()

# 알파벳 위치 리스트
# (-1로 초기화)
positions = [-1] * 26

# 문자열 순회하면서 위치 기록
for i, char in enumerate(s):
    # 'a'는 0, 'b'는 1, ..., 'z'는 25
    index = ord(char) - ord('a') 
    # 처음 등장한 경우만 저장
    if positions[index] == -1: 
        positions[index] = i

print(" ".join(map(str, positions)))