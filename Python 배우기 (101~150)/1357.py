# 뒤집힌 덧셈 

def rev(n):
    # 숫자를 문자열로 변환 후 뒤집고 다시 정수로 변환
    return int(str(n)[::-1]) 

X, Y = map(int, input().split())

# 문제 조건에 따라 연산 수행
result = rev(rev(X) + rev(Y))

print(result)