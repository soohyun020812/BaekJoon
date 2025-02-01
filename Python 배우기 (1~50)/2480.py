# 주사위 세개 

# 주사위 3개의 눈 입력 받기
a, b, c = map(int, input().split())

# 같은 눈이 3개인 경우
if a == b == c:
    print(10000 + a * 1000)
# 같은 눈이 2개인 경우
elif a == b or a == c:
    print(1000 + a * 100)
elif b == c:
    print(1000 + b * 100)
# 모두 다른 눈이 나온 경우
else:
    print(max(a, b, c) * 100)