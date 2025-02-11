# 이진수 

T = int(input()) 

for _ in range(T):
    n = int(input()) 
    # 이진수 변환 (앞의 "0b" 제거)
    binary = bin(n)[2:] 
    
    # '1'이 있는 인덱스 찾기
    positions = [i for i, bit in enumerate(binary[::-1]) if bit == '1'] 
    # 공백으로 구분하여 출력
    print(*positions) 