# 상수 

A, B = input().split()

# 숫자를 거꾸로 변환
rev_A = int(A[::-1])
rev_B = int(B[::-1])

print(max(rev_A, rev_B))