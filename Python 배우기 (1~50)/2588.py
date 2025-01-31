# 곱셈

# 첫 번째 세 자리 자연수 입력 
A = int(input())
# 두 번째 세 자리 자연수 입력 
B = int(input())

# B의 각 자리수 분리
ones = B % 10  # 1의 자리
tens = (B // 10) % 10  # 10의 자리
hundreds = B // 100  # 100의 자리

# 곱셈 과정 출력 
# (3) 1의 자리와 곱한 값
print(A * ones)
# (4) 10의 자리와 곱한 값
print(A * tens)
# (5) 100의 자리와 곱한 값
print(A * hundreds)
# (6) 전체 곱셈 결과
print(A * B)