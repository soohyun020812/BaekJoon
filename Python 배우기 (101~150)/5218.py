# 알파벳 거리 

import sys

T = int(sys.stdin.readline().strip())

# 알파벳 거리를 구하는 함수
def alphabet_distance(a, b):
    # 알파벳 숫자 ord() 함수를 이용해 매핑
    dist_a = ord(a) - ord('A') + 1 
    dist_b = ord(b) - ord('A') + 1
    # b - a를 계산하되
    # b < a이면 (b + 26) - a를 사용하여 원형 구조 유지
    return (dist_b - dist_a) if dist_b >= dist_a else (dist_b + 26 - dist_a)

for _ in range(T):
    word1, word2 = sys.stdin.readline().strip().split()
    # zip(word1, word2)를 사용해 같은 위치의 문자 쌍을 가져옴
    distances = [str(alphabet_distance(a, b)) for a, b in zip(word1, word2)]
    print("Distances:", " ".join(distances))