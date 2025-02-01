# A+B - 7

# 테스트 케이스 개수 입력받기
T = int(input()) 

for i in range(1, T + 1):
    # A와 B 입력받기
    A, B = map(int, input().split())
    # 형식에 맞게 출력
    print(f"Case #{i}: {A + B}")