# 첼시를 도와줘!

# sys : 인터프리터와 관련된 기능을 제공하는 모듈
# 프로그램 실행 환경을 제어하거나 시스템 정보를 가져올 수 있음
import sys

n = int(sys.stdin.readline().strip())

for _ in range(n):
    p = int(sys.stdin.readline().strip())
    # 가격과 선수 이름
    most_expensive = (0, "") 
    
    for _ in range(p):
        data = sys.stdin.readline().strip().split()
        price = int(data[0])
        name = data[1]
        
        if price > most_expensive[0]:
            most_expensive = (price, name)
    
    print(most_expensive[1])