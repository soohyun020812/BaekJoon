# 나머지

# 나머지를 저장할 집합
remainders = set() 

for _ in range(10): 
    num = int(input()) 
    # 42로 나눈 나머지를 집합에 추가
    remainders.add(num % 42) 

print(len(remainders)) 