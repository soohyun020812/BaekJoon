# 알파벳 개수

S = input().strip()

# 알파벳 개수를 저장할 리스트
# a-z까지 26개
alphabet_count = [0] * 26  

for char in S:
    alphabet_count[ord(char) - ord('a')] += 1  

# 공백으로 구분
print(*alphabet_count)