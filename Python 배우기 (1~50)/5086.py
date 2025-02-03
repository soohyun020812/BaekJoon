# 배수와 약수 

while True:
    a, b = map(int, input().split())
    
    # 종료 조건
    if a == 0 and b == 0:
        break
    
    # a가 b의 약수
    if b % a == 0: 
        print("factor")
    # a가 b의 배수
    elif a % b == 0: 
        print("multiple")
    else: 
        print("neither")