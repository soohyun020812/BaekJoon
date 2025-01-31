# 나머지

# 세 정수를 입력받아 정수형으로 변환
A, B, C = map(int, input().split())

# (A+B)%C 출력
print((A + B) % C)
# ((A%C) + (B%C))%C 출력
print(((A % C) + (B % C)) % C)
# (A×B)%C 출력
print((A * B) % C)
# ((A%C) × (B%C))%C 출력
print(((A % C) * (B % C)) % C)