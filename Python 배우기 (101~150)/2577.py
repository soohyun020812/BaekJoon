# 숫자의 개수

A = int(input())
B = int(input())
C = int(input())

result = A * B * C 

# 0부터 9까지의 숫자 개수 확인
for i in range(10): 
    print(str(result).count(str(i))) 