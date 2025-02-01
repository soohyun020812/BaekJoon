# 화성 수학 

# 연산자를 처리하는 함수 정의
def process_expression(expression):
    # 첫 번째 값과 연산자를 분리
    # 첫 번째 숫자
    num = float(expression[0])
    # 나머지 연산자 
    for op in expression[1:]: 
        if op == '@':
            num *= 3
        elif op == '%':
            num += 5
        elif op == '#':
            num -= 7
    return num

# 테스트 케이스 개수
T = int(input())
for _ in range(T):
    # 수식 받기, 띄어쓰기로 구분된 값들
    expression = input().split()
    result = process_expression(expression)
    # .2f : 소수점 둘째 자리까지 출력
    print(f"{result:.2f}")